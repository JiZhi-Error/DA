package com.tencent.mm.plugin.finder.live.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.e;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.finder.live.model.cgi.a;
import com.tencent.mm.plugin.finder.live.model.cgi.ac;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.live.model.cgi.ae;
import com.tencent.mm.plugin.finder.live.model.cgi.af;
import com.tencent.mm.plugin.finder.live.model.cgi.ag;
import com.tencent.mm.plugin.finder.live.model.cgi.ah;
import com.tencent.mm.plugin.finder.live.model.cgi.ai;
import com.tencent.mm.plugin.finder.live.model.cgi.b;
import com.tencent.mm.plugin.finder.live.model.cgi.d;
import com.tencent.mm.plugin.finder.live.model.cgi.l;
import com.tencent.mm.plugin.finder.live.model.cgi.o;
import com.tencent.mm.plugin.finder.live.model.cgi.u;
import com.tencent.mm.plugin.finder.live.plugin.af;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.wallet.wecoin.a.d;
import com.tencent.mm.protocal.protobuf.ape;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aqd;
import com.tencent.mm.protocal.protobuf.asu;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.ban;
import com.tencent.mm.protocal.protobuf.fgy;
import com.tencent.trtc.TRTCCloudDef;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.r;
import kotlin.g.a.u;
import kotlin.x;

public interface s {
    void E(b<? super Long, x> bVar);

    void EH(long j2);

    void Jf(int i2);

    void W(boolean z, String str);

    d a(FragmentActivity fragmentActivity, int i2, kotlin.g.a.a<x> aVar);

    void a(int i2, String str, String str2, d.a aVar);

    void a(int i2, String str, String str2, avn avn, af.a aVar);

    void a(int i2, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super ape, x> sVar);

    void a(int i2, u<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super e, ? super TRTCCloudDef.TRTCParams, ? super auf, x> uVar);

    void a(long j2, long j3, com.tencent.mm.bw.b bVar, b<? super Boolean, x> bVar2);

    void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, int i3, b.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, int i3, String str2, String str3, a.AbstractC1184a aVar);

    void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, String str2, int i3, ae.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, int i2, avn avn, String str2, int i3, String str3, ac.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, int i2, String str2, u.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, int i2, List<String> list, ai.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, String str2);

    void a(long j2, long j3, String str, byte[] bArr, String str2, ad.a aVar);

    void a(long j2, long j3, String str, byte[] bArr, LinkedList<String> linkedList, ag.a aVar);

    void a(Activity activity, fgy fgy, ResultReceiver resultReceiver, kotlin.g.a.b<? super Integer, x> bVar);

    void a(Context context, long j2, String str, Long l);

    void a(Context context, Intent intent, Integer num);

    void a(Context context, g gVar, boolean z);

    void a(Context context, String str, int i2, int i3, String str2, String str3, af.a aVar);

    void a(ah.a aVar);

    void a(axg axg);

    void a(String str, int i2, l.a aVar);

    void a(String str, com.tencent.mm.bw.b bVar, o.a aVar);

    void a(String str, boolean z, m<? super Boolean, ? super Boolean, x> mVar);

    void a(List<String> list, FinderItem finderItem);

    void a(kotlin.g.a.u<? super Boolean, ? super Boolean, ? super String, ? super Integer, ? super Integer, ? super String, ? super aqd, x> uVar);

    void a(boolean z, kotlin.g.a.s<? super Boolean, ? super Integer, ? super Integer, ? super String, ? super com.tencent.mm.plugin.finder.live.viewmodel.a, x> sVar);

    void ag(View view, int i2);

    void aty(String str);

    boolean b(com.tencent.mm.plugin.finder.live.plugin.d dVar);

    void bC(Activity activity);

    void bxD(String str);

    void c(Context context, g gVar);

    void c(String str, m<? super ayt, ? super apg, x> mVar);

    void c(r<? super Integer, ? super Integer, ? super String, ? super ban, x> rVar);

    void d(r<? super Integer, ? super Integer, ? super String, ? super asu, x> rVar);

    void dfj();

    void dfk();

    void dfl();

    void dfm();

    void dfn();

    boolean dfo();

    boolean dfp();

    boolean dfq();

    void f(m<? super Boolean, ? super Integer, x> mVar);

    void fn(Context context);

    void g(Activity activity, boolean z);

    void h(long j2, long j3, int i2);

    void k(Object obj, String str);

    public static final class a {
        public static /* synthetic */ void a(s sVar, kotlin.g.a.s sVar2) {
            AppMethodBeat.i(246273);
            sVar.a(0, sVar2);
            AppMethodBeat.o(246273);
        }

        public static /* synthetic */ void a(s sVar, long j2, long j3, kotlin.g.a.b bVar) {
            AppMethodBeat.i(246274);
            sVar.a(j2, j3, (com.tencent.mm.bw.b) null, bVar);
            AppMethodBeat.o(246274);
        }

        public static /* synthetic */ void a(s sVar, long j2, long j3, int i2) {
            AppMethodBeat.i(246275);
            sVar.h(j2, j3, i2);
            AppMethodBeat.o(246275);
        }

        public static /* synthetic */ void a(s sVar, Context context, g gVar) {
            AppMethodBeat.i(246276);
            sVar.a(context, gVar, true);
            AppMethodBeat.o(246276);
        }

        public static /* synthetic */ void a(s sVar, Context context, long j2, String str) {
            AppMethodBeat.i(260498);
            sVar.a(context, j2, str, (Long) null);
            AppMethodBeat.o(260498);
        }

        public static /* synthetic */ void a(s sVar, Activity activity) {
            AppMethodBeat.i(260499);
            sVar.g(activity, false);
            AppMethodBeat.o(260499);
        }

        public static /* synthetic */ void a(s sVar, boolean z, String str) {
            AppMethodBeat.i(260500);
            sVar.W(z, str);
            AppMethodBeat.o(260500);
        }
    }
}
