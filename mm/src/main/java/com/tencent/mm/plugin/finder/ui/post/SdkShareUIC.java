package com.tencent.mm.plugin.finder.ui.post;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.protocal.protobuf.dqh;
import com.tencent.mm.protocal.protobuf.dxx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 $2\u00020\u0001:\u0001$B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001e\u001a\u00020\u0006J\u0006\u0010\u001f\u001a\u00020\u0019J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "TAG", "", "fromAppId", "getFromAppId", "()Ljava/lang/String;", "setFromAppId", "(Ljava/lang/String;)V", "paramsJson", "getParamsJson", "setParamsJson", "remoteUrl", "getRemoteUrl", "setRemoteUrl", "shareData", "Lcom/tencent/mm/protocal/protobuf/SharePostData;", "getShareData", "()Lcom/tencent/mm/protocal/protobuf/SharePostData;", "setShareData", "(Lcom/tencent/mm/protocal/protobuf/SharePostData;)V", "videoSource", "", "getVideoSource", "()I", "setVideoSource", "(I)V", "getShareAppId", "getShareType", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class SdkShareUIC extends UIComponent {
    public static final int vRA = 1;
    public static final int vRB = 2;
    public static final a vRC = new a((byte) 0);
    private final String TAG = "Finder.SdkShareUIC";
    public String tsW = "";
    public String tsX = "";
    private dxx ueI;
    public String vRz = "";
    private int videoSource = 4;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SdkShareUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(253016);
        AppMethodBeat.o(253016);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/post/SdkShareUIC$Companion;", "", "()V", "SDK_POST_TYPE_NORMAL", "", "getSDK_POST_TYPE_NORMAL", "()I", "SDK_POST_TYPE_REMOTE_URL", "getSDK_POST_TYPE_REMOTE_URL", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(253017);
        AppMethodBeat.o(253017);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(253015);
        super.onCreate(bundle);
        dxx dxx = new dxx();
        try {
            dxx.parseFrom(getIntent().getByteArrayExtra("KEY_POST_FROM_SHARE"));
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            dxx = null;
        }
        this.ueI = dxx;
        this.vRz = dAO();
        String stringExtra = getIntent().getStringExtra("KEY_POST_REMOTE_URL");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.tsW = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("KEY_POST_FROM_APP_PARAMJSON");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.tsX = stringExtra2;
        this.videoSource = getIntent().getIntExtra("KEY_SHARE_VIDEO_SOURCE", 4);
        if (!Util.isNullOrNil(this.vRz)) {
            i iVar = i.vfo;
            i.Kr(this.videoSource);
            i iVar2 = i.vfo;
            i.auG(this.vRz);
        }
        Log.i(this.TAG, "sdkshare, fromAppId:" + this.vRz + ", remoteUrl:" + this.tsW + ", paramsJson:" + this.tsX);
        AppMethodBeat.o(253015);
    }

    public final String dAO() {
        dqh dqh;
        String str;
        dxx dxx = this.ueI;
        return (dxx == null || (dqh = dxx.MXA) == null || (str = dqh.dNI) == null) ? "" : str;
    }
}
