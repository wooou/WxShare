package com.wooou.play;

import android.graphics.Bitmap;
import android.os.Bundle;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;

public final class BundleUtil {

    public  static Bundle initBundle(ShareInfo info){
        WXWebpageObject mWXWebPageObject = new WXWebpageObject();
        mWXWebPageObject.webpageUrl = info.getUrl();
        WXMediaMessage msg = new WXMediaMessage(mWXWebPageObject);
        msg.title = info.getTitle();
        msg.description = info.getDescription();
        if(info.getBitmap()!=null){
            int WX_THUMB_SIZE = 120;
            Bitmap thumbBmp = Bitmap.createScaledBitmap(info.getBitmap(), WX_THUMB_SIZE, WX_THUMB_SIZE, true);
//            Bitmap thumb = BitmapFactory.decodeResource(paramContext.getResources(), R.mipmap.ic_launcher);
            msg.setThumbImage(thumbBmp);
        }

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("webPage");
        req.message = msg;
        req.scene = info.getSceneType(); //只能分享到微信

        Bundle bundle = new Bundle();
        req.toBundle(bundle);
        return bundle;
    }

    private static String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }
}
