package com.tencent.mm.plugin.editor.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.TbsMediaPlayer;

public class CollectEditorLinearLayoutManager extends LinearLayoutManager {
    private final int oXi = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    public int qOi = -1;
    public boolean qOj = false;

    public CollectEditorLinearLayoutManager() {
        AppMethodBeat.i(181634);
        AppMethodBeat.o(181634);
    }

    public CollectEditorLinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        AppMethodBeat.i(181635);
        AppMethodBeat.o(181635);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(181636);
        if (!this.qOj) {
            int scrollVerticallyBy = super.scrollVerticallyBy(i2, nVar, sVar);
            AppMethodBeat.o(181636);
            return scrollVerticallyBy;
        }
        if (i2 < 0) {
            z = j.be(49.0f) <= ((float) Math.abs(i2));
        } else {
            z = false;
        }
        if (i2 <= 0) {
            z2 = z;
        } else if (((float) this.oXi) + j.be(49.0f) >= ((float) i2)) {
            z2 = false;
        }
        if (!z2 || !this.qOj) {
            try {
                int scrollVerticallyBy2 = super.scrollVerticallyBy(i2, nVar, sVar);
                AppMethodBeat.o(181636);
                return scrollVerticallyBy2;
            } catch (Exception e2) {
                AppMethodBeat.o(181636);
                return 0;
            }
        } else {
            AppMethodBeat.o(181636);
            return 0;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public final int b(RecyclerView.s sVar) {
        if (this.qOi > 0) {
            return this.qOi;
        }
        return TbsMediaPlayer.TbsMediaPlayerListener.MEDIA_INFO_TIMED_TEXT_ERROR;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(181637);
        try {
            super.onLayoutChildren(nVar, sVar);
            AppMethodBeat.o(181637);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CollectEditorLinearLayoutManager", e2, "", new Object[0]);
            AppMethodBeat.o(181637);
        }
    }
}
