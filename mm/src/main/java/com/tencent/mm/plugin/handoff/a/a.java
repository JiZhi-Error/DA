package com.tencent.mm.plugin.handoff.a;

import com.tencent.mm.plugin.appbrand.config.GetOnLineInfoInfoResult;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.model.app.c;
import java.util.List;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0003H&J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0014\u001a\u00020\u0003H&J\b\u0010\u0015\u001a\u00020\u0003H&J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\u0011H&J\b\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0011H&J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010,\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0011H&J\u0016\u0010/\u001a\u00020\u00032\f\u00100\u001a\b\u0012\u0004\u0012\u00020\b01H&J\u0016\u00102\u001a\u00020\u00032\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b01H&J\u0010\u00104\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u00105\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0019H&J\u0010\u00107\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u00108\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u00109\u001a\u00020\u0011H&J\u0018\u0010:\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010;\u001a\u00020<H&J(\u0010=\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0011H&J \u0010=\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010B\u001a\u00020\u00112\u0006\u0010C\u001a\u00020\u0011H&J\u0018\u0010D\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010E\u001a\u00020FH&J\u0010\u0010G\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006H"}, hxF = {"Lcom/tencent/mm/plugin/handoff/api/IHandOffService;", "Lcom/tencent/mm/kernel/service/IService;", "add", "", "handOff", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "addHandOffFromBall", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "addMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "addWindowFromBall", "allList", "cache", "cancelUpload", "id", "", "del", "key", "delAllFloatingWindow", "fixHandOffIfNeed", "getHandOffById", "getHandOffByKey", "isSupportOpenInComputer", "", "mod", "modFromBallInfo", "notifyUserStatusChange", "onlineInfo", "Lcom/tencent/mm/plugin/appbrand/config/GetOnLineInfoInfoResult;", "onAppBackground", "onAppForeground", "onFileCreate", "onFileDestroy", "onQBFileCreate", "onQBFileDestroy", "onQBFileUpdate", "onWebViewCreate", "onWebViewDestroy", "openMultiTask", "processRequest", "message", "registerWebViewUI", "webViewUI", "Lcom/tencent/mm/ui/MMActivity;", "removeMultiTask", "restoreFromBallInfoList", "ballInfoList", "", "restoreFromMultiTaskList", "multiTaskInfoList", "sendOpenRequest", "tryEnterFloatBallInternal", "enterFloatBall", "updateMultiTask", "uploadFail", "arg", "uploadStart", "info", "Lcom/tencent/mm/pluginsdk/model/app/AppAttachInfo;", "uploadSuccess", "appId", "sdkVersion", "", "mediaId", "cdnURL", "aesKey", "uploading", "uploadedSize", "", "upsert", "api-handoff_release"})
public interface a extends com.tencent.mm.kernel.c.a {
    void O(BallInfo ballInfo);

    void a(GetOnLineInfoInfoResult getOnLineInfoInfoResult);

    void a(HandOff handOff);

    boolean a(String str, c cVar);

    void aBA(String str);

    HandOff aBx(String str);

    HandOff aBy(String str);

    void aBz(String str);

    void av(String str, String str2, String str3);

    boolean az(String str, long j2);

    void b(HandOff handOff);

    void c(HandOff handOff);

    void d(HandOff handOff);

    void d(MultiTaskInfo multiTaskInfo);

    void dYj();

    void dYk();

    boolean dYl();

    HandOff dYm();

    void del(String str);

    void e(HandOff handOff);

    void e(MultiTaskInfo multiTaskInfo);

    void e(String str, String str2, int i2, String str3);

    void f(HandOff handOff);

    void ff(List<? extends BallInfo> list);

    void fg(List<? extends MultiTaskInfo> list);

    void g(HandOff handOff);

    void h(HandOff handOff);

    void i(HandOff handOff);

    /* renamed from: if  reason: not valid java name */
    void m23if(String str, String str2);

    void j(HandOff handOff);

    void processRequest(String str);
}
