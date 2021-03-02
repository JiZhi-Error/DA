package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.b.n;
import com.tencent.mm.ui.l;
import java.util.HashSet;
import java.util.Iterator;

public final class p extends l implements n {
    private HashSet<l> kYC = new HashSet<>();

    public p() {
        AppMethodBeat.i(35256);
        AppMethodBeat.o(35256);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.n
    public final void a(l lVar) {
        AppMethodBeat.i(35257);
        if (!this.kYC.contains(lVar)) {
            this.kYC.add(lVar);
        }
        AppMethodBeat.o(35257);
    }

    @Override // com.tencent.mm.ui.chatting.d.b.n
    public final void b(l lVar) {
        AppMethodBeat.i(35258);
        this.kYC.remove(lVar);
        AppMethodBeat.o(35258);
    }

    @Override // com.tencent.mm.ui.l
    public final void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(35259);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i2, i3, intent);
        }
        AppMethodBeat.o(35259);
    }

    @Override // com.tencent.mm.ui.l
    public final boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(35260);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            if (it.next().onKeyDown(i2, keyEvent)) {
                AppMethodBeat.o(35260);
                return true;
            }
        }
        AppMethodBeat.o(35260);
        return false;
    }

    @Override // com.tencent.mm.ui.l
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        AppMethodBeat.i(35261);
        super.onRequestPermissionsResult(i2, strArr, iArr);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onRequestPermissionsResult(i2, strArr, iArr);
        }
        AppMethodBeat.o(35261);
    }

    @Override // com.tencent.mm.ui.l
    public final void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(35262);
        super.onConfigurationChanged(configuration);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onConfigurationChanged(configuration);
        }
        AppMethodBeat.o(35262);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        AppMethodBeat.i(35263);
        super.onScroll(absListView, i2, i3, i4);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onScroll(absListView, i2, i3, i4);
        }
        AppMethodBeat.o(35263);
    }

    @Override // com.tencent.mm.ui.l
    public final void onScrollStateChanged(AbsListView absListView, int i2) {
        AppMethodBeat.i(35264);
        super.onScrollStateChanged(absListView, i2);
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onScrollStateChanged(absListView, i2);
        }
        AppMethodBeat.o(35264);
    }

    @Override // com.tencent.mm.ui.l
    public final void onFinish() {
        AppMethodBeat.i(233088);
        super.onFinish();
        Iterator<l> it = this.kYC.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
        AppMethodBeat.o(233088);
    }
}
