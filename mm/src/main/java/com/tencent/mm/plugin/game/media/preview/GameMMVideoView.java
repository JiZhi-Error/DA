package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelvideo.MMVideoView;

public class GameMMVideoView extends MMVideoView {
    public GameMMVideoView(Context context) {
        super(context);
    }

    public GameMMVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public GameMMVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView
    public void setFilepath(String str) {
        AppMethodBeat.i(41214);
        super.setFilepath(str);
        AppMethodBeat.o(41214);
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public String getMediaId() {
        AppMethodBeat.i(41215);
        String mediaId = super.getMediaId();
        AppMethodBeat.o(41215);
        return mediaId;
    }

    public String getFilePath() {
        return this.jpU;
    }

    @Override // com.tencent.mm.modelvideo.MMVideoView, com.tencent.mm.pluginsdk.ui.AbstractVideoView, com.tencent.mm.pluginsdk.ui.tools.j.d
    public final void bgX() {
        AppMethodBeat.i(41216);
        super.bgX();
        AppMethodBeat.o(41216);
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final boolean dUD() {
        AppMethodBeat.i(41217);
        boolean dUD = super.dUD();
        AppMethodBeat.o(41217);
        return dUD;
    }

    @Override // com.tencent.mm.pluginsdk.ui.AbstractVideoView
    public final void showLoading() {
        AppMethodBeat.i(41218);
        super.showLoading();
        AppMethodBeat.o(41218);
    }
}
