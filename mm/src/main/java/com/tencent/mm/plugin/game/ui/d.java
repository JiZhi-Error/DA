package com.tencent.mm.plugin.game.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.game.model.aw;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.i;
import java.util.Set;

public final class d {
    private static Object lock = new Object();
    private Dialog dialog;
    private Context mContext;
    private MTimerHandler qJP = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.game.ui.d.AnonymousClass1 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(41872);
            if (d.this.dialog != null) {
                d.this.dialog.cancel();
            }
            AppMethodBeat.o(41872);
            return true;
        }
    }, false);
    int xGR = 0;
    DialogInterface.OnClickListener xOA = null;
    private int xOB = 3000;
    String xOl = null;
    private h xOw = null;
    private u xOx = null;
    private q xOy = null;
    private t xOz = null;

    static {
        AppMethodBeat.i(41877);
        AppMethodBeat.o(41877);
    }

    public d(Context context) {
        AppMethodBeat.i(41873);
        this.mContext = context;
        AppMethodBeat.o(41873);
    }

    public final void a(c cVar, l lVar) {
        AppMethodBeat.i(41874);
        if (cVar == null || lVar == null) {
            Log.e("MicroMsg.GameActionBtnHandler", "Null appInfo or null downloadInfo");
            AppMethodBeat.o(41874);
            return;
        }
        View view = new View(this.mContext);
        view.setTag(cVar);
        Log.i("MicroMsg.GameActionBtnHandler", "App Status: %d, Download Mode: %d, Download Status: %d", Integer.valueOf(cVar.status), Integer.valueOf(lVar.mode), Integer.valueOf(lVar.status));
        if (h.s(this.mContext, cVar.field_appId) || cVar.dUP()) {
            lVar.mode = 1;
        }
        if (lVar.mode == 3) {
            aw.dVY();
            int k = aw.k(this.mContext, "com.tencent.android.qqdownloader", cVar.fmT);
            Log.i("MicroMsg.GameActionBtnHandler", "qqdownloader install status:[%d], yybSupportedVersionCode:[%d]", Integer.valueOf(k), Integer.valueOf(cVar.fmT));
            if (k == -1 || k == 1 || k == 2) {
                lVar.mode = 1;
            }
        }
        switch (cVar.status) {
            case 0:
            case 3:
            case 4:
                switch (lVar.mode) {
                    case 3:
                        FileDownloadTaskInfo alg = f.cBv().alg(cVar.field_appId);
                        if (alg != null && alg.id > 0) {
                            f.cBv().Cn(alg.id);
                        }
                        if (this.xOx == null) {
                            this.xOx = new u(this.mContext);
                        }
                        u uVar = this.xOx;
                        int i2 = this.xGR;
                        String str = this.xOl;
                        uVar.xGR = i2;
                        uVar.xOl = str;
                        this.xOx.onClick(view);
                        break;
                    case 4:
                        if (!Util.isNullOrNil(cVar.fmK)) {
                            Log.i("MicroMsg.GameActionBtnHandler", "gp download url is not null and download flag is download directly by gp store");
                            r.ck(this.mContext, cVar.fmK);
                            com.tencent.mm.game.report.f.a(this.mContext, cVar.scene, cVar.dYu, cVar.position, 25, cVar.field_appId, this.xGR, cVar.dDJ, this.xOl);
                            break;
                        }
                        break;
                    default:
                        Log.d("MicroMsg.GameActionBtnHandler", "summertoken downloadInfo.mode[%d]", Integer.valueOf(lVar.mode));
                        if (this.xOw == null) {
                            this.xOw = new h(this.mContext);
                        }
                        this.xOw.setSourceScene(this.xGR);
                        this.xOw.hO(this.xOl, "");
                        this.xOw.onClick(view);
                        break;
                }
                if (cVar.xEf) {
                    Set<String> gb = e.gb(this.mContext);
                    if (!b(gb, cVar.field_appId)) {
                        if (lVar.mode != 3) {
                            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.aqo, (ViewGroup) null);
                            ((LinearLayout) inflate.findViewById(R.id.ffj)).setGravity(17);
                            ((ImageView) inflate.findViewById(R.id.ffl)).setBackgroundResource(R.drawable.bcn);
                            ((TextView) inflate.findViewById(R.id.ffh)).setText(R.string.dpb);
                            ((TextView) inflate.findViewById(R.id.ffm)).setText(R.string.dpa);
                            this.dialog = new i(this.mContext, R.style.kx);
                            this.dialog.setContentView(inflate);
                            this.dialog.setCancelable(true);
                            this.dialog.setCanceledOnTouchOutside(true);
                            this.dialog.show();
                            this.qJP.startTimer((long) this.xOB);
                        }
                        a.hhr.c(cVar.field_appId, 1, 0, null, null);
                        gb.add(cVar.field_appId);
                        e.a(this.mContext, gb);
                    }
                    AppMethodBeat.o(41874);
                    return;
                }
                break;
            case 1:
                if (this.xOz == null) {
                    this.xOz = new t(this.mContext);
                    this.xOz.xWJ = this.xOA;
                }
                this.xOz.xGR = this.xGR;
                this.xOz.onClick(view);
                com.tencent.mm.game.report.f.a(this.mContext, cVar.scene, cVar.dYu, cVar.position, 9, cVar.field_appId, this.xGR, cVar.dDJ, this.xOl);
                AppMethodBeat.o(41874);
                return;
            case 2:
                FileDownloadTaskInfo alg2 = f.cBv().alg(cVar.field_appId);
                if (alg2 != null && alg2.id > 0) {
                    f.cBv().Cn(alg2.id);
                }
                if (this.xOy == null) {
                    this.xOy = new q(this.mContext);
                }
                this.xOy.gwE = this.xGR;
                this.xOy.xVz = cVar.fmO;
                this.xOy.onClick(view);
                break;
        }
        AppMethodBeat.o(41874);
    }

    public final void a(ProgressBar progressBar, Button button, c cVar, l lVar) {
        AppMethodBeat.i(41875);
        if (progressBar == null || button == null) {
            AppMethodBeat.o(41875);
            return;
        }
        button.setEnabled(true);
        button.setVisibility(0);
        if (cVar.status == 1) {
            if (cVar.jyX) {
                button.setEnabled(false);
                button.setText(R.string.dnj);
                button.setVisibility(0);
                progressBar.setVisibility(8);
                AppMethodBeat.o(41875);
                return;
            }
            button.setText(R.string.dni);
            button.setVisibility(0);
            progressBar.setVisibility(8);
            AppMethodBeat.o(41875);
        } else if (h.a(this.mContext, cVar)) {
            int aAH = com.tencent.mm.plugin.game.e.c.aAH(cVar.field_packageName);
            if (cVar.versionCode <= aAH) {
                button.setVisibility(0);
                progressBar.setVisibility(8);
                if (cVar.scene == 12) {
                    button.setText(R.string.dob);
                } else {
                    button.setText(R.string.dqe);
                }
            } else if (lVar.status == 1) {
                progressBar.setVisibility(0);
                progressBar.setProgress(lVar.progress);
                button.setVisibility(8);
            } else {
                if (cVar.scene == 12) {
                    button.setText(R.string.dod);
                } else {
                    button.setText(R.string.dnl);
                }
                button.setVisibility(0);
                progressBar.setVisibility(8);
            }
            Log.i("MicroMsg.GameActionBtnHandler", "AppId: %s installed, local: %d, server: %d", cVar.field_appId, Integer.valueOf(aAH), Integer.valueOf(cVar.versionCode));
            AppMethodBeat.o(41875);
        } else if (cVar.dUP()) {
            button.setVisibility(0);
            progressBar.setVisibility(8);
            if (cVar.scene == 12) {
                button.setText(R.string.dob);
                AppMethodBeat.o(41875);
                return;
            }
            button.setText(R.string.dqe);
            AppMethodBeat.o(41875);
        } else {
            switch (cVar.status) {
                case 0:
                    if (lVar != null) {
                        switch (lVar.status) {
                            case 0:
                                if (cVar.scene == 12) {
                                    if (cVar.xEf) {
                                        if (!b(e.gb(this.mContext), cVar.field_appId)) {
                                            button.setText(R.string.dol);
                                        }
                                    }
                                    button.setText(R.string.dq7);
                                } else {
                                    button.setText(R.string.dq6);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 1:
                                if (lVar.mode != 3) {
                                    if (lVar.mode == 1) {
                                        progressBar.setProgress(lVar.progress);
                                        button.setVisibility(8);
                                        progressBar.setVisibility(0);
                                        break;
                                    }
                                } else {
                                    button.setText(R.string.dqc);
                                    button.setVisibility(0);
                                    progressBar.setVisibility(8);
                                    break;
                                }
                                break;
                            case 2:
                                if (cVar.scene == 12) {
                                    button.setText(R.string.dok);
                                } else {
                                    button.setText(R.string.dqa);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 3:
                                if (cVar.scene == 12) {
                                    button.setText(R.string.dq5);
                                } else {
                                    button.setText(R.string.dq4);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                        }
                    } else {
                        button.setVisibility(8);
                        progressBar.setVisibility(8);
                        AppMethodBeat.o(41875);
                        return;
                    }
                case 1:
                    if (!cVar.jyX) {
                        button.setText(R.string.dni);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    } else {
                        button.setEnabled(false);
                        button.setText(R.string.dnj);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        break;
                    }
                case 2:
                    button.setText(R.string.dnh);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                case 3:
                    if (lVar != null) {
                        switch (lVar.status) {
                            case 0:
                                button.setText(R.string.dng);
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 1:
                                if (lVar.mode != 3) {
                                    if (lVar.mode == 1) {
                                        progressBar.setProgress(lVar.progress);
                                        button.setVisibility(8);
                                        progressBar.setVisibility(0);
                                        break;
                                    }
                                } else {
                                    button.setText(R.string.dqc);
                                    break;
                                }
                                break;
                            case 2:
                                if (cVar.scene == 12) {
                                    button.setText(R.string.dok);
                                } else {
                                    button.setText(R.string.dqa);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                            case 3:
                                if (cVar.scene == 12) {
                                    button.setText(R.string.dq5);
                                } else {
                                    button.setText(R.string.dq4);
                                }
                                button.setVisibility(0);
                                progressBar.setVisibility(8);
                                break;
                        }
                    } else {
                        button.setText(R.string.dng);
                        button.setVisibility(0);
                        progressBar.setVisibility(8);
                        AppMethodBeat.o(41875);
                        return;
                    }
                case 4:
                    button.setText(R.string.dnk);
                    button.setVisibility(0);
                    progressBar.setVisibility(8);
                    break;
                default:
                    button.setVisibility(8);
                    progressBar.setVisibility(8);
                    break;
            }
            Log.i("MicroMsg.GameActionBtnHandler", "updateBtnStateAndText: %s, Status: %d, Text: %s", cVar.field_appId, Integer.valueOf(cVar.status), button.getText());
            AppMethodBeat.o(41875);
        }
    }

    private static boolean b(Set<String> set, String str) {
        AppMethodBeat.i(41876);
        if (set == null || set.isEmpty()) {
            AppMethodBeat.o(41876);
            return false;
        } else if (!set.contains(str)) {
            AppMethodBeat.o(41876);
            return false;
        } else {
            AppMethodBeat.o(41876);
            return true;
        }
    }
}
