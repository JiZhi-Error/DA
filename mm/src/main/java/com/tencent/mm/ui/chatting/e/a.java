package com.tencent.mm.ui.chatting.e;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.p;
import com.tencent.mm.ui.chatting.h.d;
import com.tencent.mm.ui.chatting.i.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class a {
    private static MMHandler PvY = new MMHandler();
    public as GUe;
    public String PkU;
    public com.tencent.mm.ui.chatting.i.a PvZ = new com.tencent.mm.ui.chatting.i.a(this);
    public b Pwa = new b(this);
    public p Pwb = new p();
    public BaseChattingUIFragment Pwc;
    public ae Pwd;
    public af Pwe;
    public int Pwf;
    public boolean Pwg = false;
    public String Pwh;
    public boolean Pwi = true;
    public boolean Pwj = false;
    private boolean Pwk = false;
    public boolean Pwl = false;
    public ConcurrentLinkedQueue<d.a> Pwm = new ConcurrentLinkedQueue<>();
    public boolean cQp = false;
    public String kIg;

    static {
        AppMethodBeat.i(35852);
        AppMethodBeat.o(35852);
    }

    public a(BaseChattingUIFragment baseChattingUIFragment, ae aeVar, af afVar) {
        AppMethodBeat.i(35817);
        this.Pwc = baseChattingUIFragment;
        this.Pwd = aeVar;
        this.Pwe = afVar;
        AppMethodBeat.o(35817);
    }

    public final as getTalker() {
        return this.GUe;
    }

    public final String getTalkerUserName() {
        AppMethodBeat.i(35818);
        if (this.GUe == null) {
            AppMethodBeat.o(35818);
            return "";
        }
        String nullAs = Util.nullAs(this.GUe.field_username, "");
        AppMethodBeat.o(35818);
        return nullAs;
    }

    public final void aw(as asVar) {
        AppMethodBeat.i(35819);
        this.GUe = asVar;
        this.Pwh = com.tencent.xweb.util.d.getMessageDigest((asVar.field_username + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(35819);
    }

    public final String bul() {
        return this.kIg != null ? this.kIg : "";
    }

    public final String gRI() {
        AppMethodBeat.i(35820);
        if (this.PkU == null) {
            this.PkU = z.aTY();
            this.PkU = as.IG(getTalkerUserName()) ? as.bjz(this.PkU) : this.PkU;
        }
        String str = this.PkU;
        AppMethodBeat.o(35820);
        return str;
    }

    public final String gOZ() {
        AppMethodBeat.i(35821);
        String nullAs = Util.nullAs(((com.tencent.mm.ui.chatting.d.b.d) bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOZ(), this.GUe.field_nickname);
        AppMethodBeat.o(35821);
        return nullAs;
    }

    public final Resources getResources() {
        AppMethodBeat.i(258937);
        Resources mMResources = this.Pwc.getMMResources();
        AppMethodBeat.o(258937);
        return mMResources;
    }

    public final View findViewById(int i2) {
        AppMethodBeat.i(35823);
        View findViewById = this.Pwc.findViewById(i2);
        AppMethodBeat.o(35823);
        return findViewById;
    }

    public final Activity getContext() {
        AppMethodBeat.i(258938);
        Activity context = this.Pwc.getContext();
        AppMethodBeat.o(258938);
        return context;
    }

    public final MMFragment gRJ() {
        return this.Pwc;
    }

    public final boolean gRK() {
        AppMethodBeat.i(35825);
        String talkerUserName = getTalkerUserName();
        if (as.IG(talkerUserName) || as.bjo(talkerUserName) || as.bjm(talkerUserName) || ab.Ji(talkerUserName)) {
            AppMethodBeat.o(35825);
            return true;
        }
        AppMethodBeat.o(35825);
        return false;
    }

    public final boolean gRL() {
        AppMethodBeat.i(35826);
        if (ab.Eq(getTalkerUserName()) || ab.Iy(getTalkerUserName())) {
            AppMethodBeat.o(35826);
            return true;
        }
        AppMethodBeat.o(35826);
        return false;
    }

    public final boolean gRM() {
        AppMethodBeat.i(35827);
        if (ab.Eq(getTalkerUserName()) || ab.Iy(getTalkerUserName()) || ((com.tencent.mm.ui.chatting.d.b.d) bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) {
            AppMethodBeat.o(35827);
            return true;
        }
        AppMethodBeat.o(35827);
        return false;
    }

    public final boolean gRO() {
        AppMethodBeat.i(258939);
        boolean HF = as.HF(getTalkerUserName());
        AppMethodBeat.o(258939);
        return HF;
    }

    public static MMHandler gRP() {
        return PvY;
    }

    public final void a(Intent intent, int i2, c.a aVar) {
        AppMethodBeat.i(35830);
        this.Pwa.a(intent, i2, aVar);
        AppMethodBeat.o(35830);
    }

    public final af gRQ() {
        return this.Pwe;
    }

    @Deprecated
    public final ListView getListView() {
        AppMethodBeat.i(35831);
        ListView listView = this.Pwd.getListView();
        AppMethodBeat.o(35831);
        return listView;
    }

    public final void amo(int i2) {
        AppMethodBeat.i(35832);
        this.Pwd.amo(i2);
        AppMethodBeat.o(35832);
    }

    public final int getFirstVisiblePosition() {
        AppMethodBeat.i(35833);
        int firstVisiblePosition = this.Pwd.getFirstVisiblePosition();
        AppMethodBeat.o(35833);
        return firstVisiblePosition;
    }

    public final int getLastVisiblePosition() {
        AppMethodBeat.i(35834);
        int lastVisiblePosition = this.Pwd.getLastVisiblePosition();
        AppMethodBeat.o(35834);
        return lastVisiblePosition;
    }

    public final int getHeaderViewsCount() {
        AppMethodBeat.i(35835);
        int headerViewsCount = this.Pwd.getHeaderViewsCount();
        AppMethodBeat.o(35835);
        return headerViewsCount;
    }

    public final int cda() {
        AppMethodBeat.i(233271);
        int cda = this.Pwd.cda();
        AppMethodBeat.o(233271);
        return cda;
    }

    public final View getChildAt(int i2) {
        AppMethodBeat.i(35836);
        View childAt = this.Pwd.getChildAt(i2);
        AppMethodBeat.o(35836);
        return childAt;
    }

    public final void b(Context context, String str, String str2, DialogInterface.OnCancelListener onCancelListener) {
        AppMethodBeat.i(233272);
        Log.i("MicroMsg.ChattingContext", "[showDialog]");
        this.Pwd.b(context, str, str2, onCancelListener);
        AppMethodBeat.o(233272);
    }

    public final void dismissDialog() {
        AppMethodBeat.i(35838);
        Log.i("MicroMsg.ChattingContext", "[dismissDialog]");
        this.Pwd.dismissDialog();
        AppMethodBeat.o(35838);
    }

    public final void hideVKB() {
        AppMethodBeat.i(35839);
        Log.i("MicroMsg.ChattingContext", "[hideVKB]");
        this.Pwd.hideVKB();
        AppMethodBeat.o(35839);
    }

    public final void cmy() {
        AppMethodBeat.i(35840);
        Log.i("MicroMsg.ChattingContext", "[notifyDataSetChange]");
        this.Pwd.cmy();
        AppMethodBeat.o(35840);
    }

    public final void amm(int i2) {
        AppMethodBeat.i(35841);
        Log.i("MicroMsg.ChattingContext", "[setSelection] pos:%s isSmooth:%s", Integer.valueOf(i2), Boolean.FALSE);
        this.Pwd.amm(i2);
        AppMethodBeat.o(35841);
    }

    public final void lf(int i2, int i3) {
        AppMethodBeat.i(35842);
        Log.i("MicroMsg.ChattingContext", "[setSelectionFromTop] pos:%s offset:%s isSmooth:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.FALSE);
        this.Pwd.lf(i2, i3);
        AppMethodBeat.o(35842);
    }

    public final void gNY() {
        AppMethodBeat.i(35843);
        Log.i("MicroMsg.ChattingContext", "[smoothScrollBy] dis:%s duration:%s", 0, 0);
        this.Pwd.gNY();
        AppMethodBeat.o(35843);
    }

    public final void BN(boolean z) {
        AppMethodBeat.i(35844);
        Log.i("MicroMsg.ChattingContext", "[scrollToLast] force:%b", Boolean.valueOf(z));
        this.Pwd.BN(z);
        AppMethodBeat.o(35844);
    }

    public final void scrollToPosition(int i2) {
        AppMethodBeat.i(35845);
        Log.i("MicroMsg.ChattingContext", "[scrollToLast] position:%d", Integer.valueOf(i2));
        this.Pwd.scrollToPosition(i2);
        AppMethodBeat.o(35845);
    }

    public final void setKeepScreenOn(boolean z) {
        AppMethodBeat.i(35846);
        Log.i("MicroMsg.ChattingContext", "[setKeepScreenOn] force:%b", Boolean.valueOf(z));
        this.Pwd.setKeepScreenOn(z);
        AppMethodBeat.o(35846);
    }

    public final void BW(boolean z) {
        AppMethodBeat.i(35847);
        Log.i("MicroMsg.ChattingContext", "[showOptionMenu] menuID:%d show:%s", 2, Boolean.valueOf(z));
        this.Pwd.showOptionMenu(2, z);
        AppMethodBeat.o(35847);
    }

    public final void showOptionMenu(boolean z) {
        AppMethodBeat.i(35848);
        Log.i("MicroMsg.ChattingContext", "[showOptionMenu] show:%s", Boolean.valueOf(z));
        this.Pwd.showOptionMenu(z);
        AppMethodBeat.o(35848);
    }

    public final void amK(int i2) {
        AppMethodBeat.i(35849);
        Log.i("MicroMsg.ChattingContext", "[updateOptionMenuIcon] menuID:%d iconID:%s", 2, Integer.valueOf(i2));
        this.Pwd.updateOptionMenuIcon(2, i2);
        AppMethodBeat.o(35849);
    }

    public final <T extends com.tencent.mm.ui.chatting.d.af, V extends Class<T>> T bh(V v) {
        AppMethodBeat.i(35850);
        T t = (T) this.PvZ.bh(v);
        AppMethodBeat.o(35850);
        return t;
    }

    public final void a(Class<? extends com.tencent.mm.ui.chatting.d.af> cls, com.tencent.mm.ui.chatting.d.af afVar) {
        AppMethodBeat.i(35851);
        this.PvZ.a(cls, afVar);
        AppMethodBeat.o(35851);
    }

    public final void setFocused(boolean z) {
        AppMethodBeat.i(179934);
        Log.i("MicroMsg.ChattingContext", "trace setFocused, isFocused %s, isSwitchMenu %s, needUpdateUI %s, trace %s", Boolean.valueOf(z), Boolean.valueOf(this.Pwk), Boolean.valueOf(this.Pwj), Util.getStack());
        if (this.Pwk) {
            AppMethodBeat.o(179934);
            return;
        }
        this.Pwi = z;
        if (z && this.Pwj) {
            this.Pwj = false;
            if (this.Pwd != null) {
                for (d.a aVar : a(this.Pwm)) {
                    Log.i("MicroMsg.ChattingContext", "[setFocused] replay action=%s", aVar);
                    this.Pwd.a(aVar);
                }
            }
            this.Pwm.clear();
        }
        AppMethodBeat.o(179934);
    }

    public final void BX(boolean z) {
        AppMethodBeat.i(179936);
        Log.i("MicroMsg.ChattingContext", "trace setSwitchMenu, isSwitchMenu %s, trace %s", Boolean.valueOf(z), Util.getStack());
        this.Pwk = z;
        AppMethodBeat.o(179936);
    }

    private static List<d.a> a(ConcurrentLinkedQueue<d.a> concurrentLinkedQueue) {
        AppMethodBeat.i(233273);
        LinkedList linkedList = new LinkedList();
        d.a aVar = null;
        Iterator<d.a> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            d.a next = it.next();
            if (next != aVar) {
                linkedList.add(next);
            } else {
                next = aVar;
            }
            aVar = next;
        }
        AppMethodBeat.o(233273);
        return linkedList;
    }

    public final boolean gRN() {
        AppMethodBeat.i(35828);
        if (!this.GUe.gBM() && !ab.Jz(getTalkerUserName()) && !as.bjm(getTalkerUserName())) {
            AppMethodBeat.o(35828);
            return true;
        } else if (((com.tencent.mm.ui.chatting.d.b.d) bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOP()) {
            AppMethodBeat.o(35828);
            return true;
        } else {
            AppMethodBeat.o(35828);
            return false;
        }
    }

    public final void startActivity(Intent intent) {
        AppMethodBeat.i(35829);
        BaseChattingUIFragment baseChattingUIFragment = this.Pwc;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, bl.axQ(), "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        baseChattingUIFragment.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(baseChattingUIFragment, "com/tencent/mm/ui/chatting/context/ChattingContext", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(35829);
    }
}
