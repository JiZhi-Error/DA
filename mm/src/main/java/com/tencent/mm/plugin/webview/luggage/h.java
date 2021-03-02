package com.tencent.mm.plugin.webview.luggage;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.x5.export.external.extension.proxy.a;

public class h extends a {
    private a IUa = new a();

    public h() {
        AppMethodBeat.i(78331);
        AppMethodBeat.o(78331);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.IUa = aVar;
        }
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(78332);
        Object onMiscCallBack = this.IUa.onMiscCallBack(str, bundle);
        AppMethodBeat.o(78332);
        return onMiscCallBack;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(78333);
        boolean onTouchEvent = this.IUa.onTouchEvent(motionEvent, view);
        AppMethodBeat.o(78333);
        return onTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(78334);
        boolean onInterceptTouchEvent = this.IUa.onInterceptTouchEvent(motionEvent, view);
        AppMethodBeat.o(78334);
        return onInterceptTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
        AppMethodBeat.i(78335);
        boolean dispatchTouchEvent = this.IUa.dispatchTouchEvent(motionEvent, view);
        AppMethodBeat.o(78335);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean overScrollBy(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, View view) {
        AppMethodBeat.i(78336);
        boolean overScrollBy = this.IUa.overScrollBy(i2, i3, i4, i5, i6, i7, i8, i9, z, view);
        AppMethodBeat.o(78336);
        return overScrollBy;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void onScrollChanged(int i2, int i3, int i4, int i5, View view) {
        AppMethodBeat.i(78337);
        this.IUa.onScrollChanged(i2, i3, i4, i5, view);
        AppMethodBeat.o(78337);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void onOverScrolled(int i2, int i3, boolean z, boolean z2, View view) {
        AppMethodBeat.i(78338);
        this.IUa.onOverScrolled(i2, i3, z, z2, view);
        AppMethodBeat.o(78338);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void computeScroll(View view) {
        AppMethodBeat.i(78339);
        this.IUa.computeScroll(view);
        AppMethodBeat.o(78339);
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public boolean onShowLongClickPopupMenu() {
        AppMethodBeat.i(78340);
        boolean onShowLongClickPopupMenu = this.IUa.onShowLongClickPopupMenu();
        AppMethodBeat.o(78340);
        return onShowLongClickPopupMenu;
    }

    @Override // com.tencent.xweb.x5.export.external.extension.proxy.a
    public void invalidate() {
        AppMethodBeat.i(78341);
        this.IUa.invalidate();
        AppMethodBeat.o(78341);
    }
}
