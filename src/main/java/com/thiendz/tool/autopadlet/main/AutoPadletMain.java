package com.thiendz.tool.autopadlet.main;

import com.thiendz.tool.autopadlet.view.AutoPadletForm;

public class AutoPadletMain {

    public static void main(String[] args) {
        AutoPadletForm.autoPadletForm = new AutoPadletForm();
        AutoPadletForm.autoPadletForm.setVisible(true);
        AutoPadletForm.autoPadletForm.setLocationRelativeTo(null);
        AutoPadletForm.autoPadletForm.setAlwaysOnTop(true);
    }
}
