package com.thiendz.tool.autopadlet.service;

import com.thiendz.tool.autopadlet.model.Channel;
import com.thiendz.tool.autopadlet.model.Post;
import com.thiendz.tool.autopadlet.model.RespType;
import com.thiendz.tool.autopadlet.util.JJson;
import com.thiendz.tool.autopadlet.util.JRequest;
import com.thiendz.tool.autopadlet.util.JsonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PadletChannelService {
    private static final String URL_XML_CHANNEL_BASE = "https://padlet.com/padlets/%s/exports/feed.xml";
    public static RespType<Channel> get(String url) {
        RespType<Channel> respType = openChannel(url);
        return respType;
    }

    private static RespType<Channel> openChannel(String url) {
        final String urlXmlChannel = String.format(URL_XML_CHANNEL_BASE, getStringId(url));
        RespType<Channel> respType = new RespType<>();
        JRequest jRequest = new JRequest(urlXmlChannel).execute();
        if (jRequest.code() != 200) {
            respType.setCode(-1);
            respType.setMessage("Channel not exists.");
            return respType;
        }
        JJson json = JsonUtils.xmlToJJson(jRequest.body());
        if (json == null) {
            respType.setCode(-2);
            respType.setMessage("XML wrong format.");
            return respType;
        }
        JJson jsonChannel = json.q(".rss.channel");
        Channel channel = new Channel();
        channel.setTitle(jsonChannel.k("title").toStr());
        channel.setLink(jsonChannel.k("link").toStr());
        channel.setDesc(jsonChannel.k("description").toStr());
        channel.setLanguage(jsonChannel.k("language").toStr());
        channel.setDate(jsonChannel.k("pubDate").toStr());
        channel.setMaster(jsonChannel.k("webMaster").toStr());
        channel.setItems(getListPost(jsonChannel.k("item")));
        
        respType.setCode(1);
        respType.setMessage("OK.");
        respType.setData(channel);

        return respType;
    }

    private static List<Post> getListPost(JJson jsonListPost) {
        List<Post> listPost = new ArrayList<>();
        if (jsonListPost != null) {
            for (JJson item : jsonListPost.toObjs()) {
                Post post = new Post();
                post.setTitle(item.k("title").toStr());
                post.setAuthor(item.k("author").toStr());
                post.setLink(item.k("link").toStr());
                post.setDesc(item.k("description").toStr());
                post.setDate(item.k("pubDate").toStr());
                post.setGuid(item.k("guid").toStr());
                post.setImg(item.q(".enclosure.url").toStr());
                post.setId(parseItemLinkToId(post.getLink()));
                listPost.add(post);
            }
        }
        return listPost;
    }
    
    private static long parseItemLinkToId(String url){
        final String REGEX_GET_ID = "/([0-9]+)$";
        Pattern p = Pattern.compile(REGEX_GET_ID);
        Matcher m = p.matcher(url);
        if(m.find()){
            return Long.parseLong(m.group().replaceAll("/", ""));
        }
        return -1;
    }
    
    private static String getStringId(String url){
        //https://padlet.com/linhhtt2/1xnub4asi237wnvu
        if(url.endsWith("/")){
            url = url.substring(0, url.length()-1);
        }
        char[] splUrl = url.toCharArray();
        int index = -1;
        for(int i=splUrl.length-1; i>-1; i--){
            if(splUrl[i] == '/'){
                index = i;
                break;
            }
        }
        if(index==-1){
            return null;
        }
        return url.substring(index+1);
    }

}
