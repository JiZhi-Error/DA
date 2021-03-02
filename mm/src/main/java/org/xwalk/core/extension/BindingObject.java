package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class BindingObject {
    private String TAG = "BindingObject";
    protected MessageHandler mHandler = new MessageHandler();
    protected ExtensionInstanceHelper mInstanceHelper;
    protected String mObjectId;

    public BindingObject() {
        AppMethodBeat.i(155183);
        AppMethodBeat.o(155183);
    }

    public Object handleMessage(MessageInfo messageInfo) {
        AppMethodBeat.i(155184);
        Object handleMessage = this.mHandler.handleMessage(messageInfo);
        AppMethodBeat.o(155184);
        return handleMessage;
    }

    public void initBindingInfo(String str, ExtensionInstanceHelper extensionInstanceHelper) {
        this.mObjectId = str;
        this.mInstanceHelper = extensionInstanceHelper;
    }

    public void onJsDestroyed() {
    }

    public void onJsBound() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }
}
