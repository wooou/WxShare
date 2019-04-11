package com.wooou.play;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;

public class MainActivity extends AppCompatActivity implements View.OnClickListener { //BridgeHandler

    private Button buttonPanel1;
    private Button buttonPanel2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPanel1 = findViewById(R.id.buttonPanel1);
        buttonPanel1.setOnClickListener(this);
        buttonPanel2 = findViewById(R.id.buttonPanel2);
        buttonPanel2.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPanel1:
                ShareInfo info = new ShareInfo("标题","描述","http://www.dinfoc.com/");
                info.setSceneType(SendMessageToWX.Req.WXSceneSession);
                WXShareUtil.doShare(this,info);
                break;
            case R.id.buttonPanel2:
                ShareInfo info2 = new ShareInfo("标题","描述","http://www.dinfoc.com/");
                info2.setSceneType(SendMessageToWX.Req.WXSceneTimeline);
                WXShareUtil.doShare(this,info2);
                break;
        }
    }


}
