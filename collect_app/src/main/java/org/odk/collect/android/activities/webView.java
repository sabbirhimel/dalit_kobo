package org.koboc.collect.android.activities;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import org.koboc.collect.android.R;


/**
 * Created by raihan on 9/29/16.
 */

public class webView extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        String urladdress = getIntent().getStringExtra("urladdress");
        WebView wv;
        wv = (WebView) findViewById(R.id.webView1);
        wv.loadUrl("file:///android_asset/"+urladdress);   // now it will not fail here
    }
}
