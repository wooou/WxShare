package com.wooou.play;

import android.util.Log;

import java.security.MessageDigest;

public class MD5Util {
    public static final String a(byte[] source)
    {
        char[] arrayOfChar = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        try{
            MessageDigest localObject = MessageDigest.getInstance("MD5");
            localObject.update(source);

            byte[] md5List  = localObject.digest();
            char[] chars = new char[md5List.length * 2];
            int i = 0;
            while (i < md5List.length){
                int m = md5List[i];
                chars[i*2] = ((char)arrayOfChar[(m >>> 4 & 0xF)]);
                chars[i*2+1] = ((char)arrayOfChar[(m & 0xF)]);
                i++;
            }
            Log.d("DEBUG",new String(chars));
            return new String(chars);

        } catch (Exception ex)  {
            Log.d("DEBUG",ex.getMessage());
            ex.printStackTrace();
        }
        return "";
    }

    static byte[] a(String paramString1, String packageName)
    {
        StringBuffer localStringBuffer = new StringBuffer();
        if (paramString1 != null) {
            localStringBuffer.append(paramString1);
        }
        localStringBuffer.append(603979778);
        localStringBuffer.append(packageName);
        localStringBuffer.append("mMcShCsTr");
        return a(
                localStringBuffer.toString().substring(1, 9).getBytes()
        ).getBytes();
    }
}
