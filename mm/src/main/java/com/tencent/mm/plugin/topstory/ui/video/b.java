package com.tencent.mm.plugin.topstory.ui.video;

import android.graphics.Point;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.aj;
import android.view.View;
import com.tencent.mm.protocal.protobuf.dyi;
import com.tencent.mm.protocal.protobuf.eit;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.ui.MMActivity;
import java.util.List;

public interface b {
    void KC();

    boolean Zx();

    void a(dyi dyi);

    void a(eiw eiw);

    void a(eiw eiw, int i2, int i3);

    void a(eiw eiw, View view);

    void a(eiw eiw, f fVar, int i2);

    void aTE(String str);

    void aTF(String str);

    boolean abU(int i2);

    void abV(int i2);

    void abW(int i2);

    void ay(View view, int i2);

    Point cZM();

    MMActivity eeF();

    l fyA();

    o fyB();

    String fyC();

    eit fyD();

    m fyE();

    r fyF();

    aj fyG();

    int fyH();

    boolean fyI();

    boolean fyJ();

    e fyK();

    boolean fyL();

    void fyM();

    int fyN();

    n fyO();

    String fyP();

    int fyQ();

    void fyR();

    int fyS();

    void fyx();

    void fyy();

    RecyclerView.LayoutManager getLayoutManager();

    RecyclerView getRecyclerView();

    int getVideoHeight();

    int getVideoWidth();

    boolean isFullscreenMode();

    void s(List<eiw> list, boolean z);
}
