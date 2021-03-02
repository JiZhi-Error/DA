package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.downloader.b.a;
import com.tencent.mm.plugin.downloader_app.api.DownloadWidgetTaskInfo;
import com.tencent.mm.plugin.downloader_app.api.a;
import com.tencent.mm.plugin.downloader_app.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownloadProgressImageView extends AppCompatImageView {
    private a.c ISD;
    private List<DownloadTaskInfo> ISE = new CopyOnWriteArrayList();
    private DownloadTaskInfo ISF;
    private int ISG = 1;
    private long lDy = -1;
    private boolean mIsDarkMode = false;
    private Paint mPaint;

    public DownloadProgressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(175733);
        Log.i("MicroMsg.DownloadProgressImageView", APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
        this.mIsDarkMode = ao.isDarkMode();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.ISD = new a.c() {
            /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.downloader.b.a.c
            public final void ag(Bundle bundle) {
                AppMethodBeat.i(175717);
                if (bundle.getBoolean("downloadInWidget")) {
                    int i2 = bundle.getInt("event");
                    int i3 = bundle.getInt("state");
                    String string = bundle.getString("appId");
                    int i4 = bundle.getInt("progress");
                    DownloadTaskInfo downloadTaskInfo = new DownloadTaskInfo();
                    downloadTaskInfo.appId = string;
                    downloadTaskInfo.state = i3;
                    downloadTaskInfo.progress = i4;
                    if (i2 == 1 || i2 == 7) {
                        if (!DownloadProgressImageView.this.ISE.contains(downloadTaskInfo)) {
                            DownloadProgressImageView.this.ISE.add(0, downloadTaskInfo);
                        } else {
                            DownloadTaskInfo downloadTaskInfo2 = (DownloadTaskInfo) DownloadProgressImageView.this.ISE.get(DownloadProgressImageView.this.ISE.indexOf(downloadTaskInfo));
                            downloadTaskInfo2.state = i3;
                            downloadTaskInfo2.progress = i4;
                        }
                    } else if (i2 == 4 || i2 == 9) {
                        DownloadProgressImageView.this.ISE.remove(downloadTaskInfo);
                    } else {
                        int indexOf = DownloadProgressImageView.this.ISE.indexOf(downloadTaskInfo);
                        if (indexOf != -1) {
                            DownloadTaskInfo downloadTaskInfo3 = (DownloadTaskInfo) DownloadProgressImageView.this.ISE.get(indexOf);
                            downloadTaskInfo3.state = i3;
                            downloadTaskInfo3.progress = i4;
                        }
                    }
                    DownloadProgressImageView.this.post(new Runnable() {
                        /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(175716);
                            DownloadProgressImageView.b(DownloadProgressImageView.this);
                            AppMethodBeat.o(175716);
                        }
                    });
                }
                AppMethodBeat.o(175717);
            }
        };
        final GetDownloadWidgeInfoTask getDownloadWidgeInfoTask = new GetDownloadWidgeInfoTask();
        getDownloadWidgeInfoTask.callback = new Runnable() {
            /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(175718);
                getDownloadWidgeInfoTask.bDK();
                DownloadProgressImageView.this.ISE = getDownloadWidgeInfoTask.ISK;
                DownloadProgressImageView.b(DownloadProgressImageView.this);
                AppMethodBeat.o(175718);
            }
        };
        getDownloadWidgeInfoTask.bDJ();
        AppBrandMainProcessService.a(getDownloadWidgeInfoTask);
        setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(175719);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("view_task", true);
                intent.putExtra("from_scene", 3);
                ((c) g.af(c.class)).a(DownloadProgressImageView.this.getContext(), intent, (a.c) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/webview/luggage/DownloadProgressImageView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(175719);
            }
        });
        AppMethodBeat.o(175733);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        AppMethodBeat.i(175734);
        super.onAttachedToWindow();
        com.tencent.mm.plugin.downloader.b.a.a(this.ISD);
        AppMethodBeat.o(175734);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(175735);
        super.onDetachedFromWindow();
        com.tencent.mm.plugin.downloader.b.a.b(this.ISD);
        AppMethodBeat.o(175735);
    }

    public void setDarkMode(boolean z) {
        AppMethodBeat.i(210857);
        this.mIsDarkMode = z;
        gbv();
        AppMethodBeat.o(210857);
    }

    private void setImageDrawableWrapper(int i2) {
        AppMethodBeat.i(210858);
        this.ISG = i2;
        gbv();
        AppMethodBeat.o(210858);
    }

    private void gbv() {
        AppMethodBeat.i(210859);
        int i2 = 0;
        switch (this.ISG) {
            case 1:
                if (!this.mIsDarkMode) {
                    i2 = R.raw.download_default;
                    break;
                } else {
                    i2 = R.raw.download_default_dark;
                    break;
                }
            case 2:
                if (!this.mIsDarkMode) {
                    i2 = R.raw.download_pause;
                    break;
                } else {
                    i2 = R.raw.download_pause_dark;
                    break;
                }
            case 3:
                if (!this.mIsDarkMode) {
                    i2 = R.raw.download_install;
                    break;
                } else {
                    i2 = R.raw.download_install_dark;
                    break;
                }
        }
        if (i2 != 0) {
            setImageResource(i2);
        }
        AppMethodBeat.o(210859);
    }

    static class GetDownloadWidgeInfoTask extends MainProcessTask {
        public static final Parcelable.Creator<GetDownloadWidgeInfoTask> CREATOR = new Parcelable.Creator<GetDownloadWidgeInfoTask>() {
            /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.GetDownloadWidgeInfoTask.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ GetDownloadWidgeInfoTask[] newArray(int i2) {
                return new GetDownloadWidgeInfoTask[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ GetDownloadWidgeInfoTask createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175725);
                GetDownloadWidgeInfoTask getDownloadWidgeInfoTask = new GetDownloadWidgeInfoTask(parcel, (byte) 0);
                AppMethodBeat.o(175725);
                return getDownloadWidgeInfoTask;
            }
        };
        public ArrayList<DownloadTaskInfo> ISK;
        public Runnable callback;

        /* synthetic */ GetDownloadWidgeInfoTask(Parcel parcel, byte b2) {
            this(parcel);
        }

        public GetDownloadWidgeInfoTask() {
            AppMethodBeat.i(175726);
            this.ISK = new ArrayList<>();
            AppMethodBeat.o(175726);
        }

        private GetDownloadWidgeInfoTask(Parcel parcel) {
            AppMethodBeat.i(175727);
            this.ISK = new ArrayList<>();
            f(parcel);
            AppMethodBeat.o(175727);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void f(Parcel parcel) {
            AppMethodBeat.i(175728);
            this.ISK = parcel.readArrayList(DownloadTaskInfo.class.getClassLoader());
            AppMethodBeat.o(175728);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175729);
            parcel.writeList(this.ISK);
            AppMethodBeat.o(175729);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjj() {
            AppMethodBeat.i(175730);
            if (g.af(c.class) == null) {
                AppMethodBeat.o(175730);
                return;
            }
            LinkedList<DownloadWidgetTaskInfo> cBR = ((c) g.af(c.class)).cBR();
            if (Util.isNullOrNil(cBR)) {
                bDU();
                AppMethodBeat.o(175730);
                return;
            }
            Iterator<DownloadWidgetTaskInfo> it = cBR.iterator();
            while (it.hasNext()) {
                DownloadWidgetTaskInfo next = it.next();
                DownloadTaskInfo downloadTaskInfo = new DownloadTaskInfo();
                downloadTaskInfo.appId = next.appId;
                downloadTaskInfo.state = next.state;
                downloadTaskInfo.progress = next.progress;
                this.ISK.add(downloadTaskInfo);
            }
            bDU();
            AppMethodBeat.o(175730);
        }

        @Override // com.tencent.mm.plugin.appbrand.ipc.MainProcessTask
        public final void bjk() {
            AppMethodBeat.i(175731);
            if (this.callback != null) {
                this.callback.run();
            }
            AppMethodBeat.o(175731);
        }

        static {
            AppMethodBeat.i(175732);
            AppMethodBeat.o(175732);
        }
    }

    /* access modifiers changed from: package-private */
    public static class DownloadTaskInfo implements Parcelable {
        public static final Parcelable.Creator<DownloadTaskInfo> CREATOR = new Parcelable.Creator<DownloadTaskInfo>() {
            /* class com.tencent.mm.plugin.webview.luggage.DownloadProgressImageView.DownloadTaskInfo.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ DownloadTaskInfo[] newArray(int i2) {
                return new DownloadTaskInfo[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ DownloadTaskInfo createFromParcel(Parcel parcel) {
                AppMethodBeat.i(175720);
                DownloadTaskInfo downloadTaskInfo = new DownloadTaskInfo(parcel, (byte) 0);
                AppMethodBeat.o(175720);
                return downloadTaskInfo;
            }
        };
        public String appId;
        public int progress;
        public int state;

        /* synthetic */ DownloadTaskInfo(Parcel parcel, byte b2) {
            this(parcel);
        }

        private DownloadTaskInfo(Parcel parcel) {
            AppMethodBeat.i(175721);
            this.appId = parcel.readString();
            this.state = parcel.readInt();
            this.progress = parcel.readInt();
            AppMethodBeat.o(175721);
        }

        public boolean equals(Object obj) {
            AppMethodBeat.i(175722);
            if (obj == null || !(obj instanceof DownloadTaskInfo) || !((DownloadTaskInfo) obj).appId.equals(this.appId)) {
                AppMethodBeat.o(175722);
                return false;
            }
            AppMethodBeat.o(175722);
            return true;
        }

        public DownloadTaskInfo() {
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(175723);
            parcel.writeString(this.appId);
            parcel.writeInt(this.state);
            parcel.writeInt(this.progress);
            AppMethodBeat.o(175723);
        }

        static {
            AppMethodBeat.i(175724);
            AppMethodBeat.o(175724);
        }
    }

    static /* synthetic */ void b(DownloadProgressImageView downloadProgressImageView) {
        AppMethodBeat.i(175736);
        Log.i("MicroMsg.DownloadProgressImageView", "updateDownloadState");
        downloadProgressImageView.ISF = null;
        if (!Util.isNullOrNil(downloadProgressImageView.ISE)) {
            Iterator<DownloadTaskInfo> it = downloadProgressImageView.ISE.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DownloadTaskInfo next = it.next();
                if (next.state == 1) {
                    downloadProgressImageView.ISF = next;
                    break;
                }
            }
            if (downloadProgressImageView.ISF == null) {
                if (downloadProgressImageView.ISE.get(0).state == 3) {
                    downloadProgressImageView.setImageDrawableWrapper(3);
                    AppMethodBeat.o(175736);
                    return;
                }
                downloadProgressImageView.setImageDrawableWrapper(2);
                AppMethodBeat.o(175736);
                return;
            }
        }
        downloadProgressImageView.setImageDrawableWrapper(1);
        AppMethodBeat.o(175736);
    }
}
