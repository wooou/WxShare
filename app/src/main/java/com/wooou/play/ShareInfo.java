package com.wooou.play;

import android.graphics.Bitmap;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;

public class ShareInfo {
    private String title;
    private String description;
    private String url;
    private Bitmap bitmap;
    private int sceneType = SendMessageToWX.Req.WXSceneSession;

    public ShareInfo() {
    }

    public ShareInfo(String title, String description, String url) {
        this.title = title;
        this.description = description;
        this.url = url;
    }


    public ShareInfo(String title, String description, String url, Bitmap bitmap) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.bitmap = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public int getSceneType() {
        return sceneType;
    }

    public void setSceneType(int sceneType) {
        this.sceneType = sceneType;
    }
}
