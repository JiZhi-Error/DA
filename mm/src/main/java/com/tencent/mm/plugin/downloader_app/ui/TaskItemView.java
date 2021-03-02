package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.downloader_app.a.c;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;

public class TaskItemView extends LinearLayout {
    ImageView qLZ;
    private AppIconView qMH;
    private TextView qMI;
    private TextView qMJ;
    private TextView qMK;
    private FrameLayout qML;
    private ProgressImageView qMM;
    private FrameLayout qMN;
    private Button qMO;
    private Button qMP;
    private DownloadUpdateDescView qMQ;
    private LinearLayout qMR;
    private ImageView qMS;
    private TextView qMT;
    boolean qMU = false;
    i qMx;

    static /* synthetic */ void c(TaskItemView taskItemView) {
        AppMethodBeat.i(184796);
        taskItemView.cCq();
        AppMethodBeat.o(184796);
    }

    public TaskItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        AppMethodBeat.i(9040);
        super.onFinishInflate();
        this.qLZ = (ImageView) findViewById(R.id.azm);
        this.qMH = (AppIconView) findViewById(R.id.dt5);
        this.qMI = (TextView) findViewById(R.id.e38);
        this.qMJ = (TextView) findViewById(R.id.e39);
        this.qMK = (TextView) findViewById(R.id.e3t);
        this.qML = (FrameLayout) findViewById(R.id.glb);
        this.qMM = (ProgressImageView) findViewById(R.id.iig);
        this.qMM.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(9028);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                com.tencent.mm.plugin.downloader.g.a alb = d.alb(TaskItemView.this.qMx.appId);
                if (alb.field_status == 1) {
                    c.b(TaskItemView.this.getContext(), TaskItemView.this.qMx);
                } else if (TaskItemView.this.qMM.qMB) {
                    c.a(TaskItemView.this.getContext(), alb.field_downloadId, new a.b() {
                        /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass1.AnonymousClass1 */

                        @Override // com.tencent.mm.plugin.downloader_app.api.a.b
                        public final void a(a.EnumC0947a aVar, long j2) {
                            AppMethodBeat.i(183827);
                            if (aVar != a.EnumC0947a.WAIT_FOR_WIFI) {
                                TaskItemView.c(TaskItemView.this);
                            }
                            AppMethodBeat.o(183827);
                        }
                    });
                } else {
                    c.a(TaskItemView.this.getContext(), TaskItemView.this.qMx, new a.b() {
                        /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass1.AnonymousClass2 */

                        @Override // com.tencent.mm.plugin.downloader_app.api.a.b
                        public final void a(a.EnumC0947a aVar, long j2) {
                            AppMethodBeat.i(184794);
                            if (aVar == a.EnumC0947a.WAIT_FOR_WIFI) {
                                TaskItemView.c(TaskItemView.this);
                            }
                            AppMethodBeat.o(184794);
                        }
                    });
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(9028);
            }
        });
        this.qMN = (FrameLayout) findViewById(R.id.ah6);
        this.qMO = (Button) findViewById(R.id.g44);
        this.qMO.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass2 */

            /* JADX WARNING: Code restructure failed: missing block: B:10:0x007f, code lost:
                if (com.tencent.mm.vfs.s.YS(r0.field_filePath) == false) goto L_0x0081;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void onClick(android.view.View r8) {
                /*
                // Method dump skipped, instructions count: 161
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass2.onClick(android.view.View):void");
            }
        });
        this.qMP = (Button) findViewById(R.id.dz3);
        this.qMP.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(9033);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                c.c(TaskItemView.this.getContext(), TaskItemView.this.qMx);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(9033);
            }
        });
        this.qMQ = (DownloadUpdateDescView) findViewById(R.id.j0g);
        this.qMR = (LinearLayout) findViewById(R.id.btf);
        this.qMS = (ImageView) findViewById(R.id.bth);
        this.qMT = (TextView) findViewById(R.id.btg);
        this.qMR.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.downloader_app.ui.TaskItemView.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(183828);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!(TaskItemView.this.qMx == null || TaskItemView.this.qMx.qLk == null || Util.isNullOrNil(TaskItemView.this.qMx.qLk.qGo))) {
                    Bundle bundle = new Bundle();
                    bundle.putString("rawUrl", TaskItemView.this.qMx.qLk.qGo);
                    ((com.tencent.mm.plugin.downloader_app.api.c) g.af(com.tencent.mm.plugin.downloader_app.api.c.class)).e(TaskItemView.this.getContext(), bundle);
                    com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, TaskItemView.this.qMx.position, 40, TaskItemView.this.qMx.appId, "", "");
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(183828);
            }
        });
        AppMethodBeat.o(9040);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(9041);
        super.onDetachedFromWindow();
        AppMethodBeat.o(9041);
    }

    public void onAttachedToWindow() {
        AppMethodBeat.i(9042);
        super.onAttachedToWindow();
        AppMethodBeat.o(9042);
    }

    public void setSelected(boolean z) {
        boolean z2;
        AppMethodBeat.i(9043);
        Log.d("MicroMsg.TaskItemView", "setSelected selected: %b, appid: %s", Boolean.valueOf(z), this.qMx.appId);
        this.qMx.isSelected = z;
        if (z) {
            com.tencent.mm.plugin.downloader_app.b.e(this.qLZ, "checkbox_cell_on");
        } else {
            com.tencent.mm.plugin.downloader_app.b.e(this.qLZ, "checkbox_cell_off");
        }
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TaskListView) {
                TaskListView taskListView = (TaskListView) parent;
                Iterator<E> it = taskListView.qNf.qMX.iterator();
                boolean z3 = false;
                boolean z4 = true;
                while (it.hasNext()) {
                    E next = it.next();
                    if (!next.cCd()) {
                        z2 = z4;
                    } else if (next.isSelected) {
                        z3 = true;
                    } else {
                        z2 = false;
                    }
                    z4 = z2;
                }
                com.tencent.mm.plugin.downloader_app.a.d.kY(z3);
                if (!z4) {
                    ((DownloadMainUI) taskListView.getContext()).ld(false);
                } else if (taskListView.getContext() instanceof DownloadMainUI) {
                    ((DownloadMainUI) taskListView.getContext()).ld(true);
                    AppMethodBeat.o(9043);
                    return;
                }
                AppMethodBeat.o(9043);
                return;
            }
        }
        AppMethodBeat.o(9043);
    }

    public void setData(i iVar) {
        AppMethodBeat.i(9044);
        this.qMx = iVar;
        if (iVar == null) {
            setVisibility(8);
            AppMethodBeat.o(9044);
            return;
        }
        setVisibility(0);
        this.qML.setVisibility(8);
        this.qMN.setVisibility(8);
        this.qMQ.setVisibility(8);
        this.qMR.setVisibility(8);
        new c.a().jbf = true;
        q.bcV().loadImage(this.qMx.iconUrl, this.qMH);
        this.qMI.setText(this.qMx.appName);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(this.qMx.appId);
        if (alb == null || !alb.field_autoDownload) {
            this.qMJ.setVisibility(8);
        } else {
            this.qMJ.setVisibility(0);
        }
        if (this.qMx.pSk) {
            if (this.qLZ.getVisibility() != 0) {
                this.qLZ.setVisibility(0);
                this.qLZ.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.e5));
            }
            setSelected(this.qMx.isSelected);
            setTaskSize(getFileSize());
            AppMethodBeat.o(9044);
            return;
        }
        this.qLZ.setVisibility(8);
        if (this.qMx.qLk != null) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.qMR.getLayoutParams();
            if (this.qMx.pSk) {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.xh);
            } else {
                layoutParams.leftMargin = getResources().getDimensionPixelSize(R.dimen.xg);
            }
            this.qMR.setLayoutParams(layoutParams);
            this.qMR.setVisibility(0);
            new c.a().jbf = true;
            q.bcV().loadImage(this.qMx.qLk.icon, this.qMS);
            if (this.qMx.qLk.qGm != null) {
                this.qMT.setText(this.qMx.qLk.qGm.value);
            }
            if (!this.qMx.qLf) {
                this.qMx.qLf = true;
                com.tencent.mm.plugin.downloader_app.b.a.a(10, 1006, this.qMx.position, 1, this.qMx.appId, "", "");
            }
        } else {
            this.qMR.setVisibility(8);
        }
        setTaskSize(getFileSize());
        this.qMQ.setVisibility(8);
        if (this.qMx.type == 4) {
            com.tencent.mm.plugin.downloader.g.a alb2 = d.alb(this.qMx.appId);
            if (alb2 == null || alb2.field_status == 0 || alb2.field_status == 5) {
                this.qML.setVisibility(8);
                setButtonText(R.string.hsx);
                this.qMQ.setData(this.qMx);
                AppMethodBeat.o(9044);
                return;
            }
            cCq();
            AppMethodBeat.o(9044);
        } else if (this.qMx.type == 6) {
            this.qML.setVisibility(8);
            setButtonText(R.string.edq);
            AppMethodBeat.o(9044);
        } else {
            cCq();
            AppMethodBeat.o(9044);
        }
    }

    /* access modifiers changed from: package-private */
    public final void cCq() {
        boolean z = false;
        AppMethodBeat.i(9045);
        Log.d("MicroMsg.TaskItemView", "updateDownloadStatus: %s", this.qMx.appId);
        this.qMN.setVisibility(8);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(this.qMx.appId);
        if (alb == null || alb.field_status == 5) {
            setTaskSize(getFileSize());
            this.qML.setVisibility(8);
            setButtonText(R.string.bn7);
            AppMethodBeat.o(9045);
            return;
        }
        if (alb.field_status == 3) {
            this.qML.setVisibility(8);
            setButtonText(R.string.e3m);
        } else if (alb.field_status == 6) {
            this.qML.setVisibility(8);
            if (e.CA(alb.field_downloadId)) {
                setButtonText(R.string.ez5);
            } else {
                setButtonText(R.string.e3m);
            }
        } else {
            this.qML.setVisibility(0);
            if (this.qMU) {
                this.qMM.cCo();
            } else if (alb.field_status == 1) {
                this.qMU = false;
                this.qMM.setProgressColor(R.color.Brand);
                this.qMM.setImageResource(R.raw.downloading);
                z = true;
            } else if (alb.field_reserveInWifi && !NetStatusUtil.isWifi(getContext())) {
                this.qML.setVisibility(0);
                this.qMM.setProgressColor(R.color.FG_1);
                this.qMM.cCp();
            } else if (alb.field_status == 4) {
                this.qML.setVisibility(8);
                setButtonText(R.string.bo9);
            } else {
                this.qMM.setProgressColor(R.color.FG_1);
                this.qMM.setImageResource("download_app_pause");
                z = true;
            }
        }
        p(alb.field_downloadedSize, z);
        AppMethodBeat.o(9045);
    }

    private void setTaskSize(long j2) {
        AppMethodBeat.i(9046);
        p(j2, false);
        AppMethodBeat.o(9046);
    }

    private void p(long j2, boolean z) {
        AppMethodBeat.i(184795);
        long fileSize = getFileSize();
        float f2 = ((float) fileSize) / 1.07374182E9f;
        float f3 = ((float) fileSize) / 1048576.0f;
        if (j2 < fileSize) {
            this.qMK.setText(String.format("%.1fMB / %.1fMB", Float.valueOf(((float) j2) / 1048576.0f), Float.valueOf(f3)));
            if (z) {
                this.qMM.setProgress((int) ((100 * j2) / fileSize));
            }
            AppMethodBeat.o(184795);
        } else if (f2 >= 1.0f) {
            this.qMK.setText(String.format("%.1fGB", Float.valueOf(f2)));
            AppMethodBeat.o(184795);
        } else {
            this.qMK.setText(String.format("%.1fMB", Float.valueOf(f3)));
            AppMethodBeat.o(184795);
        }
    }

    private void setButtonText(int i2) {
        AppMethodBeat.i(183831);
        if (i2 == R.string.e3m) {
            this.qMO.setVisibility(8);
            this.qMP.setVisibility(0);
        } else {
            this.qMP.setVisibility(8);
            this.qMO.setVisibility(0);
            this.qMO.setText(i2);
        }
        this.qMN.setVisibility(0);
        AppMethodBeat.o(183831);
    }

    public int getNamePaddingLeft() {
        AppMethodBeat.i(9047);
        if (this.qLZ.getVisibility() == 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.xh);
            AppMethodBeat.o(9047);
            return dimensionPixelSize;
        }
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(R.dimen.xg);
        AppMethodBeat.o(9047);
        return dimensionPixelSize2;
    }

    private long getFileSize() {
        AppMethodBeat.i(9048);
        com.tencent.mm.plugin.downloader.g.a alb = d.alb(this.qMx.appId);
        if (alb == null || alb.field_fileSize <= 0) {
            long j2 = this.qMx.qLi.qGq;
            AppMethodBeat.o(9048);
            return j2;
        }
        long j3 = alb.field_fileSize;
        AppMethodBeat.o(9048);
        return j3;
    }
}
