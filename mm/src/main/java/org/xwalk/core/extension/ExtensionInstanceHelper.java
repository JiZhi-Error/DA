package org.xwalk.core.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class ExtensionInstanceHelper {
    XWalkExternalExtension mExtension;
    MessageHandler mHandler = new MessageHandler(this.mExtension.getMessageHandler());
    int mId;
    private BindingObjectStore mStore;

    public ExtensionInstanceHelper(XWalkExternalExtension xWalkExternalExtension, int i2) {
        AppMethodBeat.i(155215);
        this.mId = i2;
        this.mExtension = xWalkExternalExtension;
        if (this.mExtension.isAutoJS()) {
            ReflectionHelper.registerHandlers(this.mExtension.getReflection(), this.mHandler, this.mExtension);
        }
        this.mStore = new BindingObjectStore(this.mHandler, this);
        AppMethodBeat.o(155215);
    }

    public int getId() {
        return this.mId;
    }

    public XWalkExternalExtension getExtension() {
        return this.mExtension;
    }

    public BindingObject getBindingObject(String str) {
        AppMethodBeat.i(155216);
        BindingObject bindingObject = this.mStore.getBindingObject(str);
        AppMethodBeat.o(155216);
        return bindingObject;
    }

    public boolean addBindingObject(String str, BindingObject bindingObject) {
        AppMethodBeat.i(155217);
        boolean addBindingObject = this.mStore.addBindingObject(str, bindingObject);
        AppMethodBeat.o(155217);
        return addBindingObject;
    }

    public BindingObject removeBindingObject(String str) {
        AppMethodBeat.i(155218);
        BindingObject removeBindingObject = this.mStore.removeBindingObject(str);
        AppMethodBeat.o(155218);
        return removeBindingObject;
    }

    public Object handleMessage(String str) {
        AppMethodBeat.i(155219);
        Object handleMessage = this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, str));
        AppMethodBeat.o(155219);
        return handleMessage;
    }

    public Object handleMessage(byte[] bArr) {
        AppMethodBeat.i(155220);
        Object handleMessage = this.mHandler.handleMessage(new MessageInfo(this.mExtension, this.mId, bArr));
        AppMethodBeat.o(155220);
        return handleMessage;
    }
}
