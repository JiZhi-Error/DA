package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.g;
import java.util.ArrayList;

public final class a {
    c KhA = new c();
    c KhB = new c();
    c KhC = new c();
    c KhD = new c();
    c KhE = new c();
    public c KhF = new c();
    c KhG = new c();
    c KhH = new c();
    public c KhI = new c();
    private c KhJ = new c();
    c KhK = new c();
    c KhL = new c();
    c KhM = new c();
    c KhN = new c();
    c KhO = new c();
    ArrayList<C2027a> KhP;
    c Khn = new c();
    c Kho = new c();
    c Khp = new c();
    c Khq = new c();
    c Khr = new c();
    c Khs = new c();
    c Kht = new c();
    c Khu = new c();
    c Khv = new c();
    c Khw = new c();
    c Khx = new c();
    c Khy = new c();
    c Khz = new c();
    public final String TAG = "MircoMsg.AppPanelControl";

    public static class b {
        public String desc;
        public String title;
    }

    public a() {
        AppMethodBeat.i(31493);
        AppMethodBeat.o(31493);
    }

    public final void gqd() {
        this.Khn.value = true;
        this.Kho.value = true;
        this.Khp.value = true;
        this.Khq.value = true;
        this.Khr.value = true;
        this.Khs.value = true;
        this.Kht.value = true;
        this.KhC.value = true;
        this.KhA.value = true;
        this.Khu.value = true;
        this.Khv.value = true;
        this.Khw.value = true;
        this.Khx.value = true;
        this.Khy.value = true;
        this.Khz.value = true;
        this.KhB.value = true;
        this.KhD.value = true;
        this.KhE.value = false;
        this.KhF.value = true;
        this.KhG.value = true;
        this.KhI.value = true;
        this.KhJ.value = true;
        this.KhI.value = false;
        this.KhO.value = false;
        this.KhK.value = true;
        this.KhL.value = true;
        this.KhM.value = true;
    }

    public final void gqe() {
        this.Kht.value = true;
    }

    public final void Aa(boolean z) {
        this.Khu.value = z;
    }

    public final void Ab(boolean z) {
        this.Khv.value = z;
    }

    public final void Ac(boolean z) {
        this.Khz.value = z;
    }

    public final void gqf() {
        this.KhB.value = true;
    }

    public final void Ad(boolean z) {
        this.KhD.value = z;
    }

    public final void Ae(boolean z) {
        this.KhG.value = z;
    }

    public final void Af(boolean z) {
        this.KhJ.value = z;
    }

    public final void Ag(boolean z) {
        this.KhN.value = z;
    }

    public final ArrayList<C2027a> getAppPanelUnCertainEnterArrayList() {
        AppMethodBeat.i(163211);
        if (this.KhP == null) {
            ArrayList<C2027a> arrayList = new ArrayList<>();
            AppMethodBeat.o(163211);
            return arrayList;
        }
        ArrayList<C2027a> arrayList2 = this.KhP;
        AppMethodBeat.o(163211);
        return arrayList2;
    }

    public class c {
        private boolean Kih = true;
        public boolean value = true;

        public c() {
            AppMethodBeat.i(31492);
            AppMethodBeat.o(31492);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.a$a  reason: collision with other inner class name */
    public static class C2027a extends g {
        public String KhQ;
        public int KhR;
        public String KhS;
        public String KhT;
        public int KhU;
        public String KhV;
        public String KhW;
        public b KhX = new b();
        public b KhY = new b();
        public b KhZ = new b();
        public b Kia = new b();
        public String Kib;
        public int Kic;
        public int Kid;
        public long Kie;
        public int Kif;
        public AbstractC2028a Kig;
        public String iconUrl;
        public String kHG;
        public String nnB;
        public int uSc;

        /* renamed from: com.tencent.mm.pluginsdk.ui.chat.a$a$a  reason: collision with other inner class name */
        public interface AbstractC2028a {
            String gqg();
        }

        public C2027a() {
            AppMethodBeat.i(163209);
            AppMethodBeat.o(163209);
        }
    }
}
