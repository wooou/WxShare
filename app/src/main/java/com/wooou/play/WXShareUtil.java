package com.wooou.play;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.util.Log;


public class WXShareUtil {

    private static String[] appIdList = {"wxf0a80d0ac2e82aa7", "wx64f9cf5b17af074d", "wx50d801314d9eb858", "wx299208e619de7026", "wx27a43222a6bf2931", "wx020a535dccd46c11", "wx9e7e2766ee2d0eee", "wx2ace6041e8919680", "wx8781aa7b0facd259", "wxd6415d454a022e1e"};
    private static String[] packageList = {"com.tencent.mobileqq", "com.tencent.mtt", "com.ss.android.article.news", "com.sina.weibo", "com.baidu.searchbox", "com.UCMobile", "com.UCMobile.ac", "com.UCMobile.dev", "com.UCMobile.x86", "com.UCMobile.love"};



    public static boolean doShare(Context mContext, ShareInfo info) {
        int i = getPackageIndex(mContext);
        if(i<0 ||  i> packageList.length || i> appIdList.length){
            return false;
        }
        Intent intent = IntentUtil.getShareIntent(packageList[i],appIdList[i],mContext.getPackageName(),BundleUtil.initBundle(info));
        try {
            mContext.startActivity(intent);
            Log.d("MMessageAct", "send mm message, intent=" + intent);
            return true;
        } catch (Exception ex) {
            Log.d("MMessageAct", "send fail, target ActivityNotFound,"+ex.getMessage());
            return false;
        }
    }

    private static int getPackageIndex(Context paramContext) {
        for (int j = 0; j < packageList.length; j++) {
            if (checkAppIsExist(packageList[j], paramContext)) {
                return j;
            }
        }
        return -1;
    }


    public static boolean checkAppIsExist(String packageName, Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
            return (info != null);
        }catch (Exception ex){
//            ex.printStackTrace();
        }
        return false;
    }

}
