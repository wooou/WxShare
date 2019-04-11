package com.wooou.play;

import android.content.Intent;
import android.os.Bundle;

public final class IntentUtil {

    private static final String INTENT_PACKAGE_NAME = "com.tencent.mm";
    private static final String INTENT_PACKAGE_CLASS_NAME = "com.tencent.mm.plugin.base.stub.WXEntryActivity";
    private static final String TAG = "weixin://sendreq?appid=wxd930ea5d5a258f4f";

    public static Intent getShareIntent(String usePackageName, String useAppId, String myAppPackageName, Bundle bundle){
        byte[] checkSum = MD5Util.a(TAG, myAppPackageName);
        Intent localIntent = new Intent();
        localIntent.setClassName(INTENT_PACKAGE_NAME, INTENT_PACKAGE_CLASS_NAME);
        localIntent.putExtra("_mmessage_sdkVersion", 603979778);
        localIntent.putExtra("_mmessage_appPackage", usePackageName);
        localIntent.putExtra("_mmessage_content", "weixin://sendreq?appid=" + useAppId);
        localIntent.putExtra("_mmessage_checksum", checkSum);
        if(bundle!=null) {
            localIntent.putExtras(bundle);
        }
        localIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK).addFlags(Intent.FLAG_RECEIVER_NO_ABORT);
        return localIntent;
    }

}
