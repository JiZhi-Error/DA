package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import java.util.ArrayList;
import java.util.List;

public class GameDetailAutoScrollView extends LinearLayout {
    private int rmJ = 0;
    private MTimerHandler xOF = new MTimerHandler(new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.ui.GameDetailAutoScrollView.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(41974);
            GameDetailAutoScrollView.a(GameDetailAutoScrollView.this);
            AppMethodBeat.o(41974);
            return true;
        }
    }, true);
    private ArrayList<String> xPU = new ArrayList<>();
    private ViewGroup xPV;
    private TextView xPW;
    private TextView xPX;
    private ViewGroup xPY;
    private TextView xPZ;
    private TextView xQa;
    private Animation xQb;
    private Animation xQc;

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(41975);
        this.xPV = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.app, (ViewGroup) this, false);
        this.xPW = (TextView) this.xPV.findViewById(R.id.ddr);
        this.xPX = (TextView) this.xPV.findViewById(R.id.dds);
        addView(this.xPV);
        this.xPV.setVisibility(8);
        this.xPY = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.app, (ViewGroup) this, false);
        this.xPZ = (TextView) this.xPY.findViewById(R.id.ddr);
        this.xQa = (TextView) this.xPY.findViewById(R.id.dds);
        addView(this.xPY);
        this.xPY.setVisibility(8);
        this.xQb = AnimationUtils.loadAnimation(context, R.anim.el);
        this.xQc = AnimationUtils.loadAnimation(context, R.anim.et);
        AppMethodBeat.o(41975);
    }

    public void setText(List<String> list) {
        AppMethodBeat.i(41976);
        this.xPU.clear();
        this.xOF.stopTimer();
        if (list == null || list.size() == 0 || list.size() % 2 != 0) {
            this.xPV.setVisibility(8);
            this.xPY.setVisibility(8);
            AppMethodBeat.o(41976);
            return;
        }
        this.xPU.addAll(list);
        this.rmJ = 0;
        this.xPW.setText(l.b(getContext(), this.xPU.get(0), this.xPW.getTextSize()));
        this.xPX.setText(this.xPU.get(1));
        this.xPV.setVisibility(0);
        this.xPY.setVisibility(8);
        if (this.xPU.size() / 2 == 1) {
            AppMethodBeat.o(41976);
            return;
        }
        this.xOF.startTimer(5000);
        AppMethodBeat.o(41976);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(41977);
        super.onDetachedFromWindow();
        this.xOF.stopTimer();
        AppMethodBeat.o(41977);
    }

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        AppMethodBeat.i(41978);
        if (gameDetailAutoScrollView.rmJ < (gameDetailAutoScrollView.xPU.size() / 2) - 1) {
            gameDetailAutoScrollView.rmJ++;
        } else {
            gameDetailAutoScrollView.rmJ = 0;
        }
        gameDetailAutoScrollView.xPZ.setText(l.b(gameDetailAutoScrollView.getContext(), gameDetailAutoScrollView.xPU.get(gameDetailAutoScrollView.rmJ * 2), gameDetailAutoScrollView.xPZ.getTextSize()));
        gameDetailAutoScrollView.xQa.setText(gameDetailAutoScrollView.xPU.get((gameDetailAutoScrollView.rmJ * 2) + 1));
        gameDetailAutoScrollView.xPV.startAnimation(gameDetailAutoScrollView.xQc);
        gameDetailAutoScrollView.xPV.setVisibility(8);
        gameDetailAutoScrollView.xPY.startAnimation(gameDetailAutoScrollView.xQb);
        gameDetailAutoScrollView.xPY.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.xPV;
        gameDetailAutoScrollView.xPV = gameDetailAutoScrollView.xPY;
        gameDetailAutoScrollView.xPY = viewGroup;
        TextView textView = gameDetailAutoScrollView.xPW;
        gameDetailAutoScrollView.xPW = gameDetailAutoScrollView.xPZ;
        gameDetailAutoScrollView.xPZ = textView;
        TextView textView2 = gameDetailAutoScrollView.xPX;
        gameDetailAutoScrollView.xPX = gameDetailAutoScrollView.xQa;
        gameDetailAutoScrollView.xQa = textView2;
        AppMethodBeat.o(41978);
    }
}
