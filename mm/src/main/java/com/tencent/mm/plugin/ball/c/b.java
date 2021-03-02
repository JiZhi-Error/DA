package com.tencent.mm.plugin.ball.c;

import android.animation.AnimatorListenerAdapter;
import android.graphics.Point;
import android.os.ResultReceiver;
import android.view.View;
import com.tencent.mm.plugin.ball.model.BallInfo;
import java.util.List;
import java.util.Set;

public interface b extends com.tencent.mm.kernel.c.a {

    public interface a {
        void BE(int i2);
    }

    void BC(int i2);

    void BD(int i2);

    void By(long j2);

    void Dw(boolean z);

    void a(int i2, int i3, boolean z, long j2);

    void a(int i2, e eVar);

    void a(long j2, a aVar);

    void a(ResultReceiver resultReceiver);

    void a(d dVar);

    void a(g gVar);

    void a(i iVar);

    void a(BallInfo ballInfo, ResultReceiver resultReceiver);

    void a(BallInfo ballInfo, boolean z);

    void b(int i2, e eVar);

    void b(d dVar);

    void b(g gVar);

    boolean c(AnimatorListenerAdapter animatorListenerAdapter);

    void chL();

    boolean chM();

    boolean chN();

    boolean chO();

    void chP();

    List<BallInfo> chQ();

    List<BallInfo> chR();

    Set<g> chS();

    boolean chT();

    void chU();

    boolean chV();

    void chW();

    void chX();

    long dgY();

    void dhp();

    void dn(View view);

    Point getBallPosition();

    BallInfo h(BallInfo ballInfo);

    boolean i(BallInfo ballInfo);

    void j(BallInfo ballInfo);

    void jL(boolean z);

    void jM(boolean z);

    void jN(boolean z);

    void jO(boolean z);

    void jP(boolean z);

    void jQ(boolean z);

    void jR(boolean z);

    void jS(boolean z);

    void k(BallInfo ballInfo);

    void l(BallInfo ballInfo);

    void m(BallInfo ballInfo);

    void n(BallInfo ballInfo);

    void o(BallInfo ballInfo);

    void onAccountRelease();

    void p(BallInfo ballInfo);

    void q(BallInfo ballInfo);

    void r(BallInfo ballInfo);

    void s(BallInfo ballInfo);

    void setEnableClick(boolean z);

    void t(BallInfo ballInfo);

    void u(BallInfo ballInfo);
}
