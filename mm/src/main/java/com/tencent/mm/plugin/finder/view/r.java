package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.finder.live.model.cgi.n;
import com.tencent.mm.plugin.finder.view.FinderLiveOnliveWidget;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.asm;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0012\u001a\u00020\u0013J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/LiveLogoAssistant;", "", "context", "Landroid/content/Context;", "anchorUsername", "", "position", "", "isLiveFeed", "", "(Landroid/content/Context;Ljava/lang/String;IZ)V", "getAnchorUsername", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "()Z", "getPosition", "()I", "gotoLive", "", "reportOnClick", "pageName", ch.COL_FINDEROBJECT, "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "plugin-finder_release"})
public final class r {
    final Context context;
    final String hwd;
    final int position;
    final boolean wqB;

    public r(Context context2, String str, int i2, boolean z) {
        p.h(context2, "context");
        AppMethodBeat.i(255073);
        this.context = context2;
        this.hwd = str;
        this.position = i2;
        this.wqB = z;
        AppMethodBeat.o(255073);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/view/LiveLogoAssistant$gotoLive$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderLiveGetLastObject$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderGetLatestLiveObjectResponse;", "plugin-finder_release"})
    public static final class a implements n.a {
        final /* synthetic */ r wqC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(r rVar) {
            this.wqC = rVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.n.a
        public final void a(asm asm) {
            FinderContact finderContact;
            String str;
            String str2 = null;
            AppMethodBeat.i(255071);
            p.h(asm, "resp");
            FinderObject finderObject = asm.LCD;
            if (finderObject != null) {
                FinderContact finderContact2 = finderObject.contact;
                if (finderContact2 != null) {
                    str = finderContact2.username;
                } else {
                    str = null;
                }
                if (p.j(str, this.wqC.hwd)) {
                    d.h(new C1348a(this, finderObject));
                    AppMethodBeat.o(255071);
                    return;
                }
            }
            FinderLiveOnliveWidget.a aVar = FinderLiveOnliveWidget.wnW;
            String str3 = FinderLiveOnliveWidget.TAG;
            StringBuilder append = new StringBuilder("[LiveLogoAssistant]CgiFinderLiveGetLastObject invalid resp local username:").append(this.wqC.hwd).append(",remote username:");
            if (!(finderObject == null || (finderContact = finderObject.contact) == null)) {
                str2 = finderContact.username;
            }
            Log.i(str3, append.append(str2).toString());
            AppMethodBeat.o(255071);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.view.r$a$a  reason: collision with other inner class name */
        static final class C1348a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ FinderObject tpH;
            final /* synthetic */ a wqD;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1348a(a aVar, FinderObject finderObject) {
                super(0);
                this.wqD = aVar;
                this.tpH = finderObject;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARNING: Code restructure failed: missing block: B:85:0x022e, code lost:
                if (r3.equals("101") != false) goto L_0x0230;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:86:0x0230, code lost:
                r2 = "25";
             */
            /* JADX WARNING: Code restructure failed: missing block: B:91:0x0248, code lost:
                if (r3.equals("102") != false) goto L_0x0230;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:93:0x0252, code lost:
                if (r3.equals("999") != false) goto L_0x0230;
             */
            @Override // kotlin.g.a.a
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ kotlin.x invoke() {
                /*
                // Method dump skipped, instructions count: 684
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.view.r.a.C1348a.invoke():java.lang.Object");
            }
        }
    }

    public final void dzC() {
        String str;
        AppMethodBeat.i(255072);
        String str2 = this.hwd;
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = this.hwd;
            if (str3 == null) {
                str = "";
            } else {
                str = str3;
            }
            new n(str, new a(this)).aYI();
            AppMethodBeat.o(255072);
            return;
        }
        FinderLiveOnliveWidget.a aVar = FinderLiveOnliveWidget.wnW;
        Log.i(FinderLiveOnliveWidget.TAG, "[LiveLogoAssistant]click live icon but username is empty!");
        AppMethodBeat.o(255072);
    }
}
