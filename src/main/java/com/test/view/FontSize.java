package com.test.view;

public enum FontSize {
    SMAll,
    MEDIUM,
    BIG;
    public static String getCssPath(FontSize fontSize) {
        switch (fontSize) {
            case MEDIUM:
                return "css/fontMedium.css";
            case BIG:
                return "css/fontBig.css";
            case SMAll:
                return "css/fontSmall.css";
            default:
                return null;
        }
    }
}
