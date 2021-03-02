package com.tencent.mm.plugin.webview.modeltools;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;

public final class WebViewClipBoardHelper implements ClipboardManager.OnPrimaryClipChangedListener {
    private WeakReference<WebViewUI> Jbp;
    private long lastReportTime = 0;

    public WebViewClipBoardHelper(WebViewUI webViewUI) {
        AppMethodBeat.i(79200);
        this.Jbp = new WeakReference<>(webViewUI);
        try {
            ((ClipboardManager) webViewUI.getApplicationContext().getSystemService("clipboard")).addPrimaryClipChangedListener(this);
            AppMethodBeat.o(79200);
        } catch (Exception e2) {
            AppMethodBeat.o(79200);
        }
    }

    public final void onPrimaryClipChanged() {
        AppMethodBeat.i(79201);
        if (this.Jbp.get() == null) {
            AppMethodBeat.o(79201);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastReportTime < 200) {
            AppMethodBeat.o(79201);
            return;
        }
        this.lastReportTime = currentTimeMillis;
        ClipData primaryClip = ((ClipboardManager) MMApplicationContext.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip == null) {
            AppMethodBeat.o(79201);
            return;
        }
        ClipData.Item itemAt = primaryClip.getItemAt(0);
        if (itemAt == null) {
            AppMethodBeat.o(79201);
            return;
        }
        ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper();
        clipBoardDataWrapper.url = this.Jbp.get().fZM();
        if (Util.isNullOrNil(itemAt.getText())) {
            Log.w("MicroMsg.WebViewClipBoardHelper", "onPrimaryClipChanged text is null");
            AppMethodBeat.o(79201);
            return;
        }
        clipBoardDataWrapper.length = itemAt.getText().toString().getBytes(Charset.forName(MimeTypeUtil.ContentType.DEFAULT_CHARSET)).length;
        clipBoardDataWrapper.fromScene = this.Jbp.get().getIntent().getIntExtra("from_scence", 0);
        clipBoardDataWrapper.username = this.Jbp.get().getIntent().getStringExtra("geta8key_username");
        XIPCInvoker.a(MainProcessIPCService.dkO, clipBoardDataWrapper, a.class, null);
        AppMethodBeat.o(79201);
    }

    static final class ClipBoardDataWrapper implements Parcelable {
        public static final Parcelable.Creator<ClipBoardDataWrapper> CREATOR = new Parcelable.Creator<ClipBoardDataWrapper>() {
            /* class com.tencent.mm.plugin.webview.modeltools.WebViewClipBoardHelper.ClipBoardDataWrapper.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ ClipBoardDataWrapper[] newArray(int i2) {
                return new ClipBoardDataWrapper[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ ClipBoardDataWrapper createFromParcel(Parcel parcel) {
                AppMethodBeat.i(79195);
                ClipBoardDataWrapper clipBoardDataWrapper = new ClipBoardDataWrapper(parcel);
                AppMethodBeat.o(79195);
                return clipBoardDataWrapper;
            }
        };
        int fromScene;
        int length;
        String url;
        String username;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(79196);
            parcel.writeString(this.url);
            parcel.writeInt(this.length);
            parcel.writeInt(this.fromScene);
            parcel.writeString(this.username);
            AppMethodBeat.o(79196);
        }

        ClipBoardDataWrapper() {
        }

        ClipBoardDataWrapper(Parcel parcel) {
            AppMethodBeat.i(79197);
            this.url = parcel.readString();
            this.length = parcel.readInt();
            this.fromScene = parcel.readInt();
            this.username = parcel.readString();
            AppMethodBeat.o(79197);
        }

        static {
            AppMethodBeat.i(79198);
            AppMethodBeat.o(79198);
        }
    }

    static final class a implements b<ClipBoardDataWrapper, Object> {
        private a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, com.tencent.mm.ipcinvoker.d] */
        @Override // com.tencent.mm.ipcinvoker.b
        public final /* synthetic */ void invoke(ClipBoardDataWrapper clipBoardDataWrapper, d<Object> dVar) {
            AppMethodBeat.i(79199);
            ClipBoardDataWrapper clipBoardDataWrapper2 = clipBoardDataWrapper;
            if (clipBoardDataWrapper2 != null) {
                com.tencent.mm.plugin.secinforeport.a.a aVar = com.tencent.mm.plugin.secinforeport.a.a.INSTANCE;
                com.tencent.mm.plugin.secinforeport.a.a.k(clipBoardDataWrapper2.url, clipBoardDataWrapper2.length, clipBoardDataWrapper2.fromScene, clipBoardDataWrapper2.username);
                AppMethodBeat.o(79199);
                return;
            }
            Log.e("MicroMsg.WebViewClipBoardHelper", "InvokeTask, mm received invalid data");
            AppMethodBeat.o(79199);
        }
    }
}
