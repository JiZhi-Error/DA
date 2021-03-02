package com.tencent.mm.chatroom.ui.story;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cb.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.StoryAvatarDotsView;
import java.util.ArrayList;

public class StoryLoadIconPreference extends Preference {
    private StoryAvatarDotsView gCi;
    private b.h gCj;
    private int gCk;
    private int gCl;
    private int gCm;
    private int gCn = -1;
    private int gCo = -1;
    private ArrayList<String> gCp = new ArrayList<>();
    private Context mContext;
    private View mView = null;

    public StoryLoadIconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(13018);
        cs(context);
        AppMethodBeat.o(13018);
    }

    public StoryLoadIconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(13019);
        cs(context);
        AppMethodBeat.o(13019);
    }

    private void cs(Context context) {
        AppMethodBeat.i(13020);
        setLayoutResource(R.layout.b8j);
        this.mContext = context;
        AppMethodBeat.o(13020);
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final View onCreateView(ViewGroup viewGroup) {
        AppMethodBeat.i(13021);
        if (this.mView == null) {
            View onCreateView = super.onCreateView(viewGroup);
            ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(R.id.be9);
            viewGroup2.removeAllViews();
            View.inflate(this.mContext, R.layout.c0j, viewGroup2);
            this.mView = onCreateView;
        }
        View view = this.mView;
        AppMethodBeat.o(13021);
        return view;
    }

    @Override // com.tencent.mm.ui.base.preference.Preference
    public final void onBindView(View view) {
        AppMethodBeat.i(13022);
        super.onBindView(view);
        this.gCk = a.fromDPToPix(this.mContext, 21);
        this.gCm = a.fromDPToPix(this.mContext, 2);
        this.gCl = a.fromDPToPix(this.mContext, this.gCk);
        this.gCn = this.mContext.getResources().getColor(R.color.vl);
        this.gCi = (StoryAvatarDotsView) view.findViewById(R.id.ibl);
        this.gCi.setIconSize(this.gCk + (this.gCm * 2));
        this.gCi.setIconGap(this.gCl / 2);
        if (this.gCi != null) {
            if (this.gCp.size() > 0) {
                this.gCi.setVisibility(0);
                this.gCi.setIconLayerCount(Math.min(this.gCp.size(), 3));
                if (this.gCj == null) {
                    this.gCj = new com.tencent.mm.plugin.appbrand.ui.widget.a(this.gCk, this.gCm, this.gCn);
                }
                for (int i2 = 0; i2 < this.gCi.getChildCount(); i2++) {
                    a.b.a(this.gCi.zK(i2), this.gCp.get(i2), 0.5f, false);
                }
                AppMethodBeat.o(13022);
                return;
            }
            this.gCi.setVisibility(8);
        }
        AppMethodBeat.o(13022);
    }
}
