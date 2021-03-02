package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

public class KindaJSEvent implements KJSEvent {
    private static final String TAG = "MicroMsg.KindaJSEvent";
    private KindaJsEventDelegate mDelegate;
    private KindaJSEventType mEventType = KindaJSEventType.WEB;
    @Deprecated
    private MMActivity.a mIMMOnActivityResult;
    @Deprecated
    private int mRequestCode;
    @Deprecated
    private int mResultCode = 0;

    public interface KindaJsEventDelegate extends KJSEvent {
    }

    public KindaJSEvent() {
        AppMethodBeat.i(18639);
        AppMethodBeat.o(18639);
    }

    public void setType(KindaJSEventType kindaJSEventType) {
        this.mEventType = kindaJSEventType;
    }

    public void setDelegate(KindaJsEventDelegate kindaJsEventDelegate) {
        this.mDelegate = kindaJsEventDelegate;
    }

    @Override // com.tencent.kinda.gen.KJSEvent
    public KindaJSEventType kindaGetType() {
        AppMethodBeat.i(214451);
        if (this.mDelegate != null) {
            KindaJSEventType kindaGetType = this.mDelegate.kindaGetType();
            AppMethodBeat.o(214451);
            return kindaGetType;
        }
        KindaJSEventType kindaJSEventType = this.mEventType;
        AppMethodBeat.o(214451);
        return kindaJSEventType;
    }

    @Override // com.tencent.kinda.gen.KJSEvent
    public void kindaEndWithResult(String str, HashMap<String, String> hashMap) {
        int i2;
        AppMethodBeat.i(170114);
        if (this.mDelegate != null) {
            this.mDelegate.kindaEndWithResult(str, hashMap);
            AppMethodBeat.o(170114);
            return;
        }
        String str2 = "";
        String str3 = "";
        if (hashMap != null) {
            if ("pending".equals(hashMap.get("pay_status"))) {
                i2 = 0;
            } else if ("fail".equals(hashMap.get("pay_status"))) {
                i2 = 1;
            } else {
                i2 = -1;
            }
            str2 = hashMap.get("err_code");
            str3 = hashMap.get("err_desc");
        } else {
            i2 = -1;
        }
        Log.i(TAG, "[kindaEndWithResult] The data from JsApiPayUseCase: result: %s, pay_status(isClearFailure): %d, err_code: %s, err_desc: %s", str, Integer.valueOf(i2), str2, str3);
        Intent intent = new Intent();
        this.mResultCode = 0;
        if (str.endsWith("ok")) {
            this.mResultCode = -1;
            intent.putExtra("key_is_clear_failure", i2);
        } else if (str.endsWith("fail")) {
            this.mResultCode = 5;
            intent.putExtra("key_jsapi_pay_err_code", str2);
            intent.putExtra("key_jsapi_pay_err_msg", str3);
            intent.putExtra("key_is_clear_failure", i2);
        }
        if (this.mIMMOnActivityResult != null) {
            this.mIMMOnActivityResult.d(this.mRequestCode, this.mResultCode, intent);
        }
        AppMethodBeat.o(170114);
    }

    @Override // com.tencent.kinda.gen.KJSEvent
    public void kindaCloseWebViewImpl(boolean z, VoidCallback voidCallback) {
        AppMethodBeat.i(18640);
        if (this.mDelegate != null) {
            this.mDelegate.kindaCloseWebViewImpl(z, voidCallback);
            AppMethodBeat.o(18640);
            return;
        }
        int i2 = z ? 1 : 0;
        Intent intent = new Intent();
        intent.putExtra("key_jsapi_close_page_after_pay", i2);
        Log.i(TAG, "[kindaCloseWebViewImpl] The data from JsApiPayUseCase: isCloseWebView: %b", Boolean.valueOf(z));
        if (this.mIMMOnActivityResult != null) {
            this.mIMMOnActivityResult.d(this.mRequestCode, this.mResultCode, intent);
        }
        if (voidCallback != null) {
            voidCallback.call();
        }
        AppMethodBeat.o(18640);
    }

    public void setIMMOnActivityResult(MMActivity.a aVar) {
        this.mIMMOnActivityResult = aVar;
    }

    public void setRequestCode(int i2) {
        this.mRequestCode = i2;
    }
}
