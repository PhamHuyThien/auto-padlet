/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiendz.tool.autopadlet.util;

import com.thiendz.tool.autopadlet.model.Proxy;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;


public class JRequest {
//	public static void main(String[] args) {
//		JRequest jRequest = new JRequest("https://padlet.com/linhhtt2/1xnub4asi237wnvu").execute();
//		String cookie = (jRequest.header("Set-Cookie") + ";")
//				.replaceAll("(path=/;)|(expires=.+?;)|(domain=.+?;)|(HttpOnly;)|(Secure;)|(SameSite=None;)|\s", "");
//		System.out.println(cookie);
//		String token = "";
//		Pattern p = Pattern.compile("name=\"csrf-token\" content=\"(.+?)\"");
//		Matcher m = p.matcher(jRequest.body());
//		if (m.find()) {
//			System.out.println(m.group());
//			token = m.group().replaceAll("(name=\"csrf-token\" content=)|\"", "");
//		}
//		System.out.println(token);
//		jRequest = new JRequest("https://padlet.com/api/5/reactions", JRequest.METHOD_POST).header("cookie", cookie)
//				.header("x-csrf-token", token).header("x-uid", Utils.RANDOM.nextInt(9999999))
//				.header("authorization", "Bearer " + Utils.randomCustom(64, "abcdef1234567890", ""))
//				.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4576.82 Safari/537.36")
//				.send("{\"wish_id\":1744481179,\"value\":1,\"reaction_type\":\"like\"}", ContentType.APPLICATION_JSON)
//				.execute();
//		System.out.println(jRequest.body());
//	}

	private final Executor executor;
	private final Request request;
	private HttpResponse httpResponse;

	private int errorCode;
	private String errorMessage;

	public JRequest(String url) {
		this(url, "GET");
	}

	public JRequest(String url, String method) {
		switch (method.toUpperCase()) {
		case METHOD_POST:
			request = Request.Post(url);
			break;
		case METHOD_PUT:
			request = Request.Put(url);
			break;
		case METHOD_DELETE:
			request = Request.Delete(url);
			break;
		case METHOD_OPTIONS:
			request = Request.Options(url);
			break;
		case METHOD_PATCH:
			request = Request.Patch(url);
			break;
		case METHOD_HEAD:
			request = Request.Head(url);
			break;
		case METHOD_TRADE:
			request = Request.Trace(url);
			break;
		default:
			request = Request.Get(url);
		}
		executor = Executor.newInstance();
	}

	public JRequest headers(String headers) {
		if (headers != null) {
			String[] strHeaders = headers.split("\\n");
			for (String strHeader : strHeaders) {
				String[] pairs = strHeader.split(":");
				if (pairs.length == 2) {
					String key = pairs[0].trim();
					String value = pairs[1].trim();
					header(key, value);
				}
			}
		}
		return this;
	}

	public JRequest header(Object name, Object value) {
		if (name != null && value != null) {
			request.addHeader(name.toString(), value.toString());
		}
		return this;
	}

	public JRequest auth(String host, int port) {
		return auth(new Proxy(host, port, null, null));
	}

	public JRequest auth(String host, int port, String user, String pass) {
		return auth(new Proxy(host, port, user, pass));
	}

	public JRequest auth(Proxy proxy) {
		if (proxy != null) {
			request.viaProxy(proxy.getHttpHost());
			if (proxy.getUser() != null && proxy.getPass() != null) {
				executor.auth(proxy.getHttpHost(), proxy.getUser(), proxy.getPass());
			}
		}
		return this;
	}

	public JRequest timeout(int timeout) {
		if (timeout > 0) {
			request.connectTimeout(timeout);
		}
		return this;
	}

	public JRequest send(String data) {
		return send(data, ContentType.APPLICATION_FORM_URLENCODED);
	}

	public JRequest send(String data, ContentType contentType) {
		if (data != null) {
			request.bodyString(data, contentType);
		}
		return this;
	}

	public JRequest execute() {
		try {
			httpResponse = executor.execute(request).returnResponse();
		} catch (IOException e) {
			errorCode = -1;
			errorMessage = e.toString();
		}
		return this;
	}

	public int code() {
		if (httpResponse != null) {
			return httpResponse.getStatusLine().getStatusCode();
		}
		return -1;
	}

	public String message() {
		if (httpResponse != null) {
			return httpResponse.getStatusLine().getReasonPhrase();
		}
		return null;
	}

	public String body() {
		return body(Charset.forName("utf8"));
	}

	public String body(Charset charset) {
		if (httpResponse != null) {
			try {
				return EntityUtils.toString(httpResponse.getEntity(), charset);
			} catch (IOException e) {
				errorCode = -2;
				errorMessage = e.toString();
			}
		}
		return null;
	}

	public String header(String name) {
		Map<String, String> mapHeader = headers();
		return mapHeader != null ? mapHeader.get(name) : null;
	}

	public Map<String, String> headers() {
		if (httpResponse != null) {
			try {
				Map<String, String> mapHeader = new HashMap<>();
				Header[] headers = httpResponse.getAllHeaders();
				for (Header header : headers) {
					String key = header.getName();
					String value = header.getValue();
					if (mapHeader.containsKey(key)) {
						value += "; " + mapHeader.get(key);
					}
					mapHeader.put(key, value);
				}
				return mapHeader;
			} catch (Exception e) {
				errorCode = -3;
				errorMessage = e.toString();
			}
		}
		return null;
	}

	public int errorCode() {
		return errorCode;
	}

	public String errorMessage() {
		return errorMessage;
	}

	//
	public static final String METHOD_POST = "POST";
	public static final String METHOD_PUT = "PUT";
	public static final String METHOD_GET = "GET";
	public static final String METHOD_DELETE = "DELETE";
	public static final String METHOD_TRADE = "TRADE";
	public static final String METHOD_CONNECT = "CONNECT";
	public static final String METHOD_OPTIONS = "OPTIONS";
	public static final String METHOD_PATCH = "PATCH";
	public static final String METHOD_HEAD = "HEAD";
}
