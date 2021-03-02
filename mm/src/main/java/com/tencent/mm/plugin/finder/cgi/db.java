package com.tencent.mm.plugin.finder.cgi;

import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.fhf;
import com.tencent.mm.protocal.protobuf.fhg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u000f\u001a\u00020\u0010H\u0002J4\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u000e\u0010\n\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSwitchIdentity;", "Lcom/tencent/mm/plugin/finder/cgi/FinderCgi;", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "finderUserName", "", "targetAliasRole", "", "callback", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "(Ljava/lang/String;ILcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSwitchIdentity$CallBack;)V", "TAG", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityRequest;", "getTargetAliasRole", "()I", "initReqResp", "", "onCgiEnd", "errType", "errCode", "errMsg", "resp", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "CallBack", "plugin-finder_release"})
public final class db extends an<fhg> {
    private final String TAG = "Finder.CgiFinderLiveSwitchIdentity";
    private a UHK;
    private fhf UHL;
    private final int UHM;

    @l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveSwitchIdentity$CallBack;", "", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSwitchIdentityResponse;", "plugin-finder_release"})
    public interface a {
        void a(fhg fhg);

        void bxA(String str);
    }

    public db(String str, int i2, a aVar) {
        Integer num;
        p.h(str, "finderUserName");
        AppMethodBeat.i(260179);
        this.UHM = i2;
        this.UHK = aVar;
        this.UHL = new fhf();
        this.UHL.LAt = str;
        this.UHL.Vjr = this.UHM;
        fhf fhf = this.UHL;
        am amVar = am.tuw;
        fhf.LBM = am.cXY();
        d.a aVar2 = new d.a();
        aVar2.c(this.UHL);
        fhg fhg = new fhg();
        fhg.setBaseResponse(new BaseResponse());
        fhg.getBaseResponse().ErrMsg = new dqi();
        aVar2.d(fhg);
        aVar2.MB("/cgi-bin/micromsg-bin/finderliveswitchidentity");
        aVar2.sG(4163);
        c(aVar2.aXF());
        String str2 = this.TAG;
        StringBuilder append = new StringBuilder("init finder_username:").append(this.UHL.LAt).append(",target_alias_role:").append(this.UHL.Vjr).append(",live_identity:");
        aov aov = this.UHL.LBM;
        if (aov != null) {
            num = Integer.valueOf(aov.Viq);
        } else {
            num = null;
        }
        Log.i(str2, append.append(num).toString());
        AppMethodBeat.o(260179);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, int, java.lang.String, com.tencent.mm.protocal.protobuf.dpc, com.tencent.mm.ak.q] */
    @Override // com.tencent.mm.plugin.finder.cgi.an
    public final /* synthetic */ void b(int i2, int i3, String str, fhg fhg, q qVar) {
        AppMethodBeat.i(260178);
        fhg fhg2 = fhg;
        p.h(fhg2, "resp");
        Log.i(this.TAG, "[onCgiEnd] errType=" + i2 + " errCode=" + i3 + " errMsg=" + str + " thread=" + Thread.currentThread());
        if (i2 == 0 && i3 == 0) {
            Log.i(this.TAG, "set finder live alias role:" + this.UHM);
            a aVar = this.UHK;
            if (aVar != null) {
                aVar.a(fhg2);
                AppMethodBeat.o(260178);
                return;
            }
            AppMethodBeat.o(260178);
            return;
        }
        a aVar2 = this.UHK;
        if (aVar2 != null) {
            aVar2.bxA(str);
            AppMethodBeat.o(260178);
            return;
        }
        AppMethodBeat.o(260178);
    }
}
