package com.tencent.mm.ui.chatting.multitask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.a.b;
import com.tencent.mm.plugin.multitask.f.c;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class a extends b {
    private boolean PDX = false;
    private boolean PDY = false;
    private String id;

    public a(Activity activity) {
        super(activity);
    }

    public final void e(boolean z, boolean z2, String str) {
        this.PDX = z;
        this.PDY = z2;
        this.id = str;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final Bitmap getBitmap() {
        AppMethodBeat.i(233463);
        c cVar = c.AgL;
        if (c.Ss(4)) {
            AppMethodBeat.o(233463);
            return null;
        } else if (this.PDX) {
            com.tencent.mm.plugin.multitask.f.a aVar = com.tencent.mm.plugin.multitask.f.a.AgJ;
            Bitmap aGR = com.tencent.mm.plugin.multitask.f.a.aGR(MMApplicationContext.getContext().getExternalCacheDir().getAbsolutePath() + "//" + this.id);
            AppMethodBeat.o(233463);
            return aGR;
        } else if (this.PDY) {
            Bitmap bitmap = super.getBitmap();
            AppMethodBeat.o(233463);
            return bitmap;
        } else {
            AppMethodBeat.o(233463);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getContentView() {
        AppMethodBeat.i(233464);
        View contentView = super.getContentView();
        if (contentView == null) {
            ViewGroup chG = chG();
            contentView = null;
            int i2 = 0;
            int i3 = 1;
            int i4 = 1;
            while (i2 < chG.getChildCount()) {
                View childAt = chG.getChildAt(i2);
                if (childAt == null || childAt.getHeight() * childAt.getWidth() <= i3 * i4) {
                    childAt = contentView;
                } else {
                    int width = childAt.getWidth();
                    i4 = childAt.getHeight();
                    i3 = width;
                }
                i2++;
                contentView = childAt;
            }
            AppMethodBeat.o(233464);
        } else {
            AppMethodBeat.o(233464);
        }
        return contentView;
    }

    @Override // com.tencent.mm.plugin.multitask.a.b, com.tencent.mm.plugin.multitask.a.a
    public final View getMaskView() {
        AppMethodBeat.i(233465);
        ViewGroup chG = chG();
        View view = null;
        int i2 = 0;
        int i3 = 1;
        int i4 = 1;
        while (i2 < chG.getChildCount()) {
            View childAt = chG.getChildAt(i2);
            if (childAt == null || childAt.getHeight() * childAt.getWidth() <= i3 * i4) {
                childAt = view;
            } else {
                int width = childAt.getWidth();
                i4 = childAt.getHeight();
                i3 = width;
            }
            i2++;
            view = childAt;
        }
        AppMethodBeat.o(233465);
        return view;
    }
}
