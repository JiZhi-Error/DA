package org.xwalk.core.extension;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.XWalkExtension;

/* access modifiers changed from: package-private */
public class XWalkCoreExtensionBridge extends XWalkExtension implements XWalkExternalExtensionBridge {
    private XWalkExternalExtension mExtension;

    public XWalkCoreExtensionBridge(XWalkExternalExtension xWalkExternalExtension) {
        super(xWalkExternalExtension.getExtensionName(), xWalkExternalExtension.getJsApi(), xWalkExternalExtension.getEntryPoints());
        AppMethodBeat.i(155275);
        this.mExtension = xWalkExternalExtension;
        AppMethodBeat.o(155275);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void onMessage(int i2, String str) {
        AppMethodBeat.i(155276);
        this.mExtension.onMessage(i2, str);
        AppMethodBeat.o(155276);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void onBinaryMessage(int i2, byte[] bArr) {
        AppMethodBeat.i(155277);
        this.mExtension.onBinaryMessage(i2, bArr);
        AppMethodBeat.o(155277);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public String onSyncMessage(int i2, String str) {
        AppMethodBeat.i(155278);
        String onSyncMessage = this.mExtension.onSyncMessage(i2, str);
        AppMethodBeat.o(155278);
        return onSyncMessage;
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void onInstanceCreated(int i2) {
        AppMethodBeat.i(155279);
        this.mExtension.onInstanceCreated(i2);
        AppMethodBeat.o(155279);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void onInstanceDestroyed(int i2) {
        AppMethodBeat.i(155280);
        this.mExtension.onInstanceDestroyed(i2);
        AppMethodBeat.o(155280);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onDestroy() {
        AppMethodBeat.i(155281);
        this.mExtension.onDestroy();
        AppMethodBeat.o(155281);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onResume() {
        AppMethodBeat.i(155282);
        this.mExtension.onResume();
        AppMethodBeat.o(155282);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onPause() {
        AppMethodBeat.i(155283);
        this.mExtension.onPause();
        AppMethodBeat.o(155283);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onStart() {
        AppMethodBeat.i(155284);
        this.mExtension.onStart();
        AppMethodBeat.o(155284);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onStop() {
        AppMethodBeat.i(155285);
        this.mExtension.onStop();
        AppMethodBeat.o(155285);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(155286);
        this.mExtension.onNewIntent(intent);
        AppMethodBeat.o(155286);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void postMessage(int i2, String str) {
        AppMethodBeat.i(155287);
        super.postMessage(i2, str);
        AppMethodBeat.o(155287);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void postBinaryMessage(int i2, byte[] bArr) {
        AppMethodBeat.i(155288);
        super.postBinaryMessage(i2, bArr);
        AppMethodBeat.o(155288);
    }

    @Override // org.xwalk.core.extension.XWalkExternalExtensionBridge, org.xwalk.core.XWalkExtension
    public void broadcastMessage(String str) {
        AppMethodBeat.i(155289);
        super.broadcastMessage(str);
        AppMethodBeat.o(155289);
    }
}
