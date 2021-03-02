package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.topstory.ui.video.fs.f;
import com.tencent.mm.protocal.protobuf.eiw;

public final class l extends f {
    public l(Context context) {
        super(context);
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar, com.tencent.mm.plugin.topstory.ui.video.fs.f
    public final int getLayoutId() {
        return R.layout.c3t;
    }

    @Override // com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar, com.tencent.mm.plugin.topstory.ui.video.g, com.tencent.mm.plugin.websearch.ui.WebSearchVideoPlayerSeekBar, com.tencent.mm.plugin.topstory.ui.video.fs.f
    public final void init() {
        AppMethodBeat.i(126405);
        super.init();
        findViewById(R.id.brt).setVisibility(8);
        this.GoL.setVisibility(8);
        this.GoK.setVisibility(8);
        this.GoJ.setVisibility(8);
        findViewById(R.id.i32).setVisibility(8);
        AppMethodBeat.o(126405);
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.f
    public final void setOnUpdateProgressLenListener(f.a aVar) {
    }

    @Override // com.tencent.mm.plugin.topstory.ui.video.fs.f
    public final void n(eiw eiw) {
        AppMethodBeat.i(126406);
        super.n(eiw);
        findViewById(R.id.brt).setVisibility(8);
        this.GoL.setVisibility(8);
        this.GoK.setVisibility(8);
        this.GoJ.setVisibility(8);
        findViewById(R.id.i32).setVisibility(8);
        AppMethodBeat.o(126406);
    }
}
