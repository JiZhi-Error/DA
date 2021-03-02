package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMOpenSDKToMsdkManager {
    protected static final String CLIENT_NAME = "downloadSDKClient";
    protected static final String TAG = "OpensdkToMsdkManager";
    protected static TMOpenSDKToMsdkManager mInstance = null;
    protected int authorizedState = 0;
    protected PopDialog dialog = null;
    protected boolean hasNotify = false;
    protected long insertActionId = -1;
    protected boolean isInstallFinished = false;
    protected TMOpenSDKAuthorizedInfo mAuthorizedInfo = null;
    protected TMAssistantDownloadSDKClient mClient = null;
    protected Context mContext = null;
    protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener = new ITMAssistantDownloadSDKClientListener() {
        /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass9 */

        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        }

        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public void OnDownloadSDKTaskStateChanged(final TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, final String str, int i2, int i3, String str2, boolean z, boolean z2) {
            AppMethodBeat.i(102175);
            TMLog.i(TMOpenSDKToMsdkManager.TAG, "OnDownloadSDKTaskStateChanged client:" + tMAssistantDownloadSDKClient + " | state:" + i2 + " | errorcode:" + i3 + " | errorMsg:" + str2);
            if (tMAssistantDownloadSDKClient == null || TextUtils.isEmpty(str)) {
                AppMethodBeat.o(102175);
            } else if (4 == i2) {
                TMOpenSDKToMsdkManager.this.mSubMessageHandler.post(new Runnable() {
                    /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass9.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(102174);
                        try {
                            String str = tMAssistantDownloadSDKClient.getDownloadTaskState(str).mSavePath;
                            if (!TextUtils.isEmpty(str)) {
                                Message message = new Message();
                                message.what = 0;
                                message.obj = str;
                                TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                            }
                            AppMethodBeat.o(102174);
                        } catch (Exception e2) {
                            Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                            AppMethodBeat.o(102174);
                        }
                    }
                });
                AppMethodBeat.o(102175);
            } else {
                if (5 == i2) {
                    Message message = new Message();
                    message.what = 3;
                    TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                }
                AppMethodBeat.o(102175);
            }
        }

        @Override // com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener
        public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j2, long j3) {
            AppMethodBeat.i(102176);
            Message message = new Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putLong("receiveDataLen", j2);
            bundle.putLong("totalDataLen", j3);
            message.setData(bundle);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
            AppMethodBeat.o(102176);
        }
    };
    protected String mDownloadUrl = null;
    protected GetAuthorizedHttpRequest mHttpRequest = null;
    protected MMHandler mMainMessageHandler = null;
    protected TMQQDownloaderOpenSDK mOpenSDK = null;
    protected IGetAuthorizedHttpRequestListenner mRequestListener = new IGetAuthorizedHttpRequestListenner() {
        /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass2 */

        @Override // com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner
        public void onGetAuthorizedRequestFinished(AuthorizedResult authorizedResult, int i2) {
            AppMethodBeat.i(102167);
            Message message = new Message();
            if (i2 != 0) {
                message.what = 5;
                message.obj = Integer.valueOf(i2);
            } else if (authorizedResult == null) {
                AppMethodBeat.o(102167);
                return;
            } else {
                message.what = 4;
                message.obj = authorizedResult;
            }
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
            AppMethodBeat.o(102167);
        }
    };
    protected MMHandler mSubMessageHandler = null;
    protected HandlerThread mSubMessagehandlerThread = null;
    protected int mSupportVersionCode = 0;
    protected ITMOpenSDKToMsdkListener mToMsdkListener = null;
    protected View.OnClickListener negativeBtnListenner = new View.OnClickListener() {
        /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass5 */
        private byte _hellAccFlag_;

        public void onClick(View view) {
            AppMethodBeat.i(102170);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (TMOpenSDKToMsdkManager.this.dialog.isShowing()) {
                TMOpenSDKToMsdkManager.this.dialog.dismiss();
                TMOpenSDKToMsdkManager.this.mHttpRequest = null;
            }
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            createTipsInfoLog.cancelBtnClickCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            try {
                if (TMOpenSDKToMsdkManager.this.mClient != null) {
                    TMOpenSDKToMsdkManager.this.pauseDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
            }
            if (TMOpenSDKToMsdkManager.this.authorizedState == 2) {
                TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(true, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            } else {
                TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(false, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            }
            a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102170);
        }
    };
    protected View.OnClickListener positiveBtnListener = new View.OnClickListener() {
        /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass6 */
        private byte _hellAccFlag_;

        public void onClick(View view) {
            AppMethodBeat.i(102171);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (TMOpenSDKToMsdkManager.this.mContext == null) {
                a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(102171);
                return;
            }
            ActionButton actionButton = (ActionButton) view.getTag();
            try {
                switch (TMOpenSDKToMsdkManager.this.mOpenSDK.checkQQDownloaderInstalled(TMOpenSDKToMsdkManager.this.mSupportVersionCode)) {
                    case 0:
                        try {
                            TMOpenSDKToMsdkManager.this.startToQQDownloaderAuthorized(actionButton.jumpUrl);
                            break;
                        } catch (Exception e2) {
                            Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                            break;
                        }
                    case 1:
                        TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                        break;
                    case 2:
                        TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                        break;
                }
            } catch (Exception e3) {
                Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e3, "", new Object[0]);
            }
            a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102171);
        }
    };
    protected View.OnClickListener retryBtnListener = new View.OnClickListener() {
        /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass4 */
        private byte _hellAccFlag_;

        public void onClick(View view) {
            AppMethodBeat.i(102169);
            b bVar = new b();
            bVar.bm(view);
            a.b("com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (TMOpenSDKToMsdkManager.this.mAuthorizedInfo == null) {
                a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(102169);
                return;
            }
            if (TMOpenSDKToMsdkManager.this.mContext != null) {
                TMOpenSDKToMsdkManager.this.getUserAuthorizedInfo(TMOpenSDKToMsdkManager.this.mAuthorizedInfo, TMOpenSDKToMsdkManager.this.mContext);
            }
            TMOpenSDKToMsdkManager.this.dialog.dismiss();
            a.a(this, "com/tencent/tmassistantsdk/openSDK/opensdktomsdk/TMOpenSDKToMsdkManager$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(102169);
        }
    };
    protected TMAssistantSDKChannel sdkChannel = null;

    private TMOpenSDKToMsdkManager(Context context) {
        AppMethodBeat.i(102177);
        this.mContext = context;
        AppMethodBeat.o(102177);
    }

    public static synchronized TMOpenSDKToMsdkManager getInstance(Context context) {
        TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager;
        synchronized (TMOpenSDKToMsdkManager.class) {
            AppMethodBeat.i(102178);
            if (mInstance == null) {
                mInstance = new TMOpenSDKToMsdkManager(context);
            }
            tMOpenSDKToMsdkManager = mInstance;
            AppMethodBeat.o(102178);
        }
        return tMOpenSDKToMsdkManager;
    }

    public void initOpenSDK(ITMOpenSDKToMsdkListener iTMOpenSDKToMsdkListener) {
        AppMethodBeat.i(102179);
        this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
        this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
        this.mToMsdkListener = iTMOpenSDKToMsdkListener;
        this.sdkChannel = new TMAssistantSDKChannel();
        this.mSubMessageHandler = new MMHandler("OpenSDKToMsdkManager");
        this.mMainMessageHandler = new MMHandler(Looper.getMainLooper(), new MMHandler.Callback() {
            /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass1 */

            public boolean handleMessage(Message message) {
                AppMethodBeat.i(102166);
                switch (message.what) {
                    case 0:
                        int i2 = message.arg1;
                        TMOpenSDKToMsdkManager.this.handleInstall(message.obj.toString(), i2);
                        break;
                    case 1:
                        Bundle data = message.getData();
                        if (data != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloading(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                            break;
                        }
                        break;
                    case 3:
                        TMOpenSDKToMsdkManager.this.handleDownloadFailed();
                        break;
                    case 4:
                        AuthorizedResult authorizedResult = (AuthorizedResult) message.obj;
                        if (authorizedResult != null) {
                            TMOpenSDKToMsdkManager.this.onNetworkFinishedSuccess(authorizedResult);
                            break;
                        }
                        break;
                    case 5:
                        TMOpenSDKToMsdkManager.this.onNetworkFinishedFailed(((Integer) message.obj).intValue());
                        break;
                    case 6:
                        Bundle data2 = message.getData();
                        if (data2 != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloadContinue(data2.getLong("receiveDataLen"), data2.getLong("totalDataLen"));
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(102166);
                return false;
            }
        });
        AppMethodBeat.o(102179);
    }

    public void onDestroy() {
        AppMethodBeat.i(102180);
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (this.mOpenSDK != null) {
            this.mOpenSDK.destroyQQDownloaderOpenSDK();
        }
        this.mToMsdkListener = null;
        this.hasNotify = false;
        this.isInstallFinished = false;
        this.authorizedState = 0;
        this.mHttpRequest = null;
        this.mAuthorizedInfo = null;
        this.sdkChannel = null;
        this.insertActionId = -1;
        if (this.mContext != null) {
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
        }
        this.mClient = null;
        AppMethodBeat.o(102180);
    }

    public void onResume() {
        AppMethodBeat.i(102181);
        tryToCloseDialog();
        if (this.hasNotify) {
            AppMethodBeat.o(102181);
        } else if (this.authorizedState == 2) {
            AppMethodBeat.o(102181);
        } else {
            if ((this.authorizedState == 3 || this.authorizedState == 0) && this.mContext != null) {
                getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
            }
            AppMethodBeat.o(102181);
        }
    }

    public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo, Context context) {
        AppMethodBeat.i(102182);
        if (context != null) {
            this.mContext = context;
        }
        TMLog.i(TAG, "getUserAuthorizedInfo method called!");
        this.hasNotify = false;
        if (this.mHttpRequest != null) {
            TMLog.i(TAG, "mHttpRequest != null, request didn't finish!");
            AppMethodBeat.o(102182);
            return;
        }
        if (tMOpenSDKAuthorizedInfo != null) {
            this.mAuthorizedInfo = tMOpenSDKAuthorizedInfo;
            if (this.mHttpRequest == null) {
                this.authorizedState = 1;
                this.mHttpRequest = new GetAuthorizedHttpRequest();
                this.mHttpRequest.setListenner(this.mRequestListener);
                this.mHttpRequest.sendRequest(tMOpenSDKAuthorizedInfo);
                AppMethodBeat.o(102182);
                return;
            }
        } else {
            TMLog.i(TAG, "AuthorizedInfo object is null!");
        }
        AppMethodBeat.o(102182);
    }

    /* access modifiers changed from: protected */
    public void onNetworkFinishedSuccess(AuthorizedResult authorizedResult) {
        AppMethodBeat.i(102183);
        this.mDownloadUrl = authorizedResult.downloadUrl;
        this.mSupportVersionCode = authorizedResult.versionCode;
        this.mHttpRequest = null;
        TMLog.i(TAG, "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + authorizedResult.hasAuthoried + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
        if (authorizedResult.hasAuthoried == 1) {
            this.authorizedState = 2;
            if (authorizedResult.tipsInfo != null) {
                showDialog(authorizedResult.tipsInfo);
                AppMethodBeat.o(102183);
                return;
            }
            notifyAuthorizedFinished(true, this.mAuthorizedInfo);
            AppMethodBeat.o(102183);
            return;
        }
        this.authorizedState = 3;
        if (authorizedResult.tipsInfo != null) {
            showDialog(authorizedResult.tipsInfo);
            AppMethodBeat.o(102183);
            return;
        }
        onServerException(authorizedResult.errorCode);
        TMLog.i(TAG, "not in white list and no tips!");
        AppMethodBeat.o(102183);
    }

    /* access modifiers changed from: protected */
    public void onNetworkFinishedFailed(int i2) {
        AppMethodBeat.i(102184);
        if (i2 == 606 || i2 == 602 || i2 == 601 || i2 == 704) {
            onServerException(i2);
            AppMethodBeat.o(102184);
            return;
        }
        onNetworkException(i2);
        AppMethodBeat.o(102184);
    }

    /* access modifiers changed from: protected */
    public void onServerException(int i2) {
        AppMethodBeat.i(102185);
        if (this.mContext == null) {
            AppMethodBeat.o(102185);
            return;
        }
        Res res = new Res(this.mContext);
        TipsInfo tipsInfo = new TipsInfo();
        tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
        if (i2 == 602 || i2 == 601) {
            tipsInfo.content = this.mContext.getString(res.string("white_list_network_error"));
        } else {
            tipsInfo.content = this.mContext.getString(res.string("white_list_server_error"));
        }
        ArrayList<ActionButton> arrayList = new ArrayList<>();
        ActionButton actionButton = new ActionButton();
        actionButton.jumpType = 4;
        String string = this.mContext.getString(res.string("white_list_positive_retry_again"));
        actionButton.textInstalled = string;
        actionButton.textUninstalled = string;
        ActionButton actionButton2 = new ActionButton();
        actionButton2.jumpType = 3;
        String string2 = this.mContext.getString(res.string("white_list_negtive"));
        actionButton2.textInstalled = string2;
        actionButton2.textUninstalled = string2;
        arrayList.add(actionButton);
        arrayList.add(actionButton2);
        tipsInfo.actionButton = arrayList;
        showDialog(tipsInfo);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.networkErrorTipsCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        AppMethodBeat.o(102185);
    }

    /* access modifiers changed from: protected */
    public void onNetworkException(int i2) {
        String string;
        AppMethodBeat.i(102186);
        if (this.mContext == null) {
            AppMethodBeat.o(102186);
            return;
        }
        Res res = new Res(this.mContext);
        if (1 == i2) {
            string = this.mContext.getString(res.string("white_list_network_not_connected"));
        } else {
            string = this.mContext.getString(res.string("white_list_network_error"));
        }
        TipsInfo tipsInfo = new TipsInfo();
        tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
        tipsInfo.content = string;
        ArrayList<ActionButton> arrayList = new ArrayList<>();
        ActionButton actionButton = new ActionButton();
        actionButton.jumpType = 3;
        arrayList.add(actionButton);
        String string2 = this.mContext.getString(res.string("white_list_negtive_known"));
        actionButton.textInstalled = string2;
        actionButton.textUninstalled = string2;
        tipsInfo.actionButton = arrayList;
        showDialog(tipsInfo);
        this.mHttpRequest = null;
        this.mDownloadUrl = "";
        this.authorizedState = 3;
        TMLog.i(TAG, "network error happened!");
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.networkErrorTipsCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        AppMethodBeat.o(102186);
    }

    /* access modifiers changed from: protected */
    public void notifyAuthorizedFinished(boolean z, TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        AppMethodBeat.i(102187);
        TMLog.i(TAG, "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
        if (this.mToMsdkListener == null) {
            TMLog.i(TAG, "before notifyAuthorizedFinished: mToMsdkListener = null !");
        }
        if (!(this.mToMsdkListener == null || this.mAuthorizedInfo == null)) {
            TMLog.i(TAG, "notifyAuthorizedFinished: result:".concat(String.valueOf(z)));
            this.mToMsdkListener.onAuthorizedFinished(z, this.mAuthorizedInfo);
            this.mHttpRequest = null;
            this.hasNotify = true;
        }
        AppMethodBeat.o(102187);
    }

    /* access modifiers changed from: protected */
    public void showDialog(TipsInfo tipsInfo) {
        ArrayList<ActionButton> arrayList;
        AppMethodBeat.i(102188);
        if (this.mContext == null) {
            AppMethodBeat.o(102188);
        } else if (this.dialog != null && this.dialog.isShowing()) {
            AppMethodBeat.o(102188);
        } else if (!(this.mContext instanceof Activity) || !((Activity) this.mContext).isFinishing()) {
            Res res = new Res(this.mContext);
            if (!(tipsInfo == null || (arrayList = tipsInfo.actionButton) == null || arrayList.size() <= 0)) {
                this.dialog = new PopDialog(this.mContext, res.style("while_list_dialog"), arrayList.size());
                this.dialog.show();
                this.dialog.setTitle(tipsInfo.title);
                this.dialog.setContent(tipsInfo.content);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ActionButton actionButton = arrayList.get(i2);
                    if (actionButton.jumpType == 3) {
                        this.dialog.setNegativeBtnText(actionButton.textInstalled);
                        this.dialog.setNegativeBtnClickListener(this.negativeBtnListenner);
                    } else if (actionButton.jumpType == 4) {
                        this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                        this.dialog.setPositiveBtnClickListener(this.retryBtnListener);
                    } else {
                        try {
                            switch (this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode)) {
                                case 0:
                                    this.dialog.setPositiveBtnText(actionButton.textInstalled);
                                    TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
                                    createTipsInfoLog.authorizedTipsCount++;
                                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                                    break;
                                case 1:
                                    this.dialog.setPositiveBtnText(actionButton.textUninstalled);
                                    continueDownload();
                                    break;
                                case 2:
                                    this.dialog.setPositiveBtnText(this.mContext.getString(res.string("white_list_positive_update")));
                                    continueDownload();
                                    break;
                            }
                        } catch (Exception e2) {
                            Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                        }
                        this.dialog.setPositiveBtnTag(actionButton);
                        this.dialog.setPositiveBtnClickListener(this.positiveBtnListener);
                    }
                }
            }
            AppMethodBeat.o(102188);
        } else {
            TMLog.i(TAG, "context is finishing!  context" + this.mContext);
            AppMethodBeat.o(102188);
        }
    }

    /* access modifiers changed from: protected */
    public void continueDownload() {
        AppMethodBeat.i(102189);
        this.mSubMessageHandler.post(new Runnable() {
            /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(102168);
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = TMOpenSDKToMsdkManager.this.getClient().getDownloadTaskState(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                    if (downloadTaskState != null) {
                        if (downloadTaskState.mState == 3) {
                            Message message = new Message();
                            message.what = 6;
                            Bundle bundle = new Bundle();
                            bundle.putLong("receiveDataLen", downloadTaskState.mReceiveDataLen);
                            bundle.putLong("totalDataLen", downloadTaskState.mTotalDataLen);
                            message.setData(bundle);
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                        } else if (downloadTaskState.mState == 4) {
                            Message message2 = new Message();
                            message2.what = 0;
                            message2.arg1 = 1;
                            message2.obj = downloadTaskState.mSavePath;
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message2);
                        }
                    }
                    if (downloadTaskState == null || downloadTaskState.mState != 4) {
                        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                        createTipsInfoLog.downloadTipsCount++;
                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        AppMethodBeat.o(102168);
                        return;
                    }
                    TipsInfoLog createTipsInfoLog2 = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                    createTipsInfoLog2.installTipsCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog2);
                    AppMethodBeat.o(102168);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(102168);
                }
            }
        });
        AppMethodBeat.o(102189);
    }

    /* access modifiers changed from: protected */
    public void tryToCloseDialog() {
        AppMethodBeat.i(102190);
        if (this.mOpenSDK == null) {
            AppMethodBeat.o(102190);
        } else if (this.mContext == null) {
            AppMethodBeat.o(102190);
        } else {
            try {
                int checkQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                if (this.isInstallFinished && checkQQDownloaderInstalled == 0) {
                    this.mHttpRequest = null;
                    this.isInstallFinished = false;
                    this.mDownloadUrl = null;
                    if (this.dialog.isShowing()) {
                        this.dialog.dismiss();
                    }
                    TMAssistantDownloadSDKManager.closeAllService(this.mContext);
                    this.mClient = null;
                    if (isExitsAction(this.insertActionId)) {
                        this.mOpenSDK.startQQDownloader(this.mContext);
                    }
                }
                AppMethodBeat.o(102190);
            } catch (Exception e2) {
                Log.printErrStackTrace(TAG, e2, "", new Object[0]);
                AppMethodBeat.o(102190);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isExitsAction(long j2) {
        AppMethodBeat.i(102191);
        if (j2 < 0) {
            AppMethodBeat.o(102191);
            return false;
        } else if (this.sdkChannel == null) {
            AppMethodBeat.o(102191);
            return false;
        } else {
            Iterator<TMAssistantSDKChannelDataItem> it = this.sdkChannel.getChannelDataItemList().iterator();
            while (it.hasNext()) {
                TMAssistantSDKChannelDataItem next = it.next();
                if (((long) next.mDBIdentity) == j2 && next.mDataItemEndTime - next.mDataItemStartTime <= 300000) {
                    AppMethodBeat.o(102191);
                    return true;
                }
            }
            AppMethodBeat.o(102191);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void handleInstall(String str, int i2) {
        AppMethodBeat.i(102192);
        if (this.mContext == null) {
            AppMethodBeat.o(102192);
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_install")));
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(102192);
            return;
        }
        this.isInstallFinished = true;
        if (i2 == 1) {
            AppMethodBeat.o(102192);
            return;
        }
        r.b(this.mContext, str, null, false);
        AppMethodBeat.o(102192);
    }

    /* access modifiers changed from: protected */
    public void handleDownloadFailed() {
        AppMethodBeat.i(102193);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(102193);
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_retry")));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
        AppMethodBeat.o(102193);
    }

    /* access modifiers changed from: protected */
    public void handleDownloading(long j2, long j3) {
        AppMethodBeat.i(102194);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(102194);
            return;
        }
        String string = this.mContext.getString(new Res(this.mContext).string("white_list_positive_downloading"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j2)) + 0.0f) / ((float) j3))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j2) + 0.0f) / ((float) j3)) * ((float) this.dialog.downloadProgressBar.getMax())));
        TMLog.i(TAG, "handleDownloading : receivedlen:" + j2 + " | totalLen:" + j3);
        AppMethodBeat.o(102194);
    }

    /* access modifiers changed from: protected */
    public void handleDownloadContinue(long j2, long j3) {
        AppMethodBeat.i(102195);
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            AppMethodBeat.o(102195);
            return;
        }
        Res res = new Res(this.mContext);
        String string = this.mContext.getString(res.string("white_list_positive_continue"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j2)) + 0.0f) / ((float) j3))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j2) + 0.0f) / ((float) j3)) * ((float) this.dialog.downloadProgressBar.getMax())));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
        AppMethodBeat.o(102195);
    }

    /* access modifiers changed from: protected */
    public void startToQQDownloaderAuthorized(String str) {
        AppMethodBeat.i(102196);
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(102196);
            return;
        }
        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
        createTipsInfoLog.authorizedBtnClickCount++;
        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        if (!(this.mContext == null || this.mOpenSDK == null)) {
            this.mOpenSDK.startToAuthorized(this.mContext, str);
        }
        AppMethodBeat.o(102196);
    }

    /* access modifiers changed from: protected */
    public void startDownloadTask(final String str, final String str2) {
        AppMethodBeat.i(102197);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(102197);
            return;
        }
        this.dialog.setPositiveBtnEnable(false);
        this.mSubMessageHandler.post(new Runnable() {
            /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass7 */

            public void run() {
                AppMethodBeat.i(102172);
                if (!(TMOpenSDKToMsdkManager.this.mContext == null || TMOpenSDKToMsdkManager.this.mOpenSDK == null || TextUtils.isEmpty(str2))) {
                    TMOpenSDKToMsdkManager.this.insertActionId = TMOpenSDKToMsdkManager.this.mOpenSDK.addDownloadTaskFromAuthorize(str2);
                }
                TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                if (client == null) {
                    AppMethodBeat.o(102172);
                    return;
                }
                try {
                    int startDownloadTask = client.startDownloadTask(str, "application/vnd.android.package-archive");
                    if (4 == startDownloadTask) {
                        String str = client.getDownloadTaskState(str).mSavePath;
                        Message message = new Message();
                        message.what = 0;
                        message.obj = str;
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                    } else if (startDownloadTask == 0) {
                        TMLog.i(TMOpenSDKToMsdkManager.TAG, "start success!");
                    } else if (1 == startDownloadTask) {
                        Message message2 = new Message();
                        message2.what = 5;
                        message2.obj = 1;
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message2);
                    } else {
                        Message message3 = new Message();
                        message3.what = 3;
                        TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message3);
                    }
                    if (startDownloadTask == 4) {
                        TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                        createTipsInfoLog.installBtnClickCount++;
                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        AppMethodBeat.o(102172);
                        return;
                    }
                    TipsInfoLog createTipsInfoLog2 = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                    createTipsInfoLog2.downloadBtnClickCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog2);
                    AppMethodBeat.o(102172);
                } catch (Exception e2) {
                    Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                    AppMethodBeat.o(102172);
                }
            }
        });
        AppMethodBeat.o(102197);
    }

    /* access modifiers changed from: protected */
    public void pauseDownloadTask(final String str) {
        AppMethodBeat.i(102198);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(102198);
        } else if (this.mAuthorizedInfo == null) {
            AppMethodBeat.o(102198);
        } else {
            this.mSubMessageHandler.post(new Runnable() {
                /* class com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.AnonymousClass8 */

                public void run() {
                    AppMethodBeat.i(102173);
                    TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                    try {
                        if (client.getDownloadTaskState(str) != null) {
                            client.pauseDownloadTask(str);
                            AppMethodBeat.o(102173);
                            return;
                        }
                        TMLog.i(TMOpenSDKToMsdkManager.TAG, "getDownloadTaskState taskinfo is null!");
                        AppMethodBeat.o(102173);
                    } catch (Exception e2) {
                        Log.printErrStackTrace(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                        AppMethodBeat.o(102173);
                    }
                }
            });
            AppMethodBeat.o(102198);
        }
    }

    /* access modifiers changed from: protected */
    public TMAssistantDownloadSDKClient getClient() {
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient;
        AppMethodBeat.i(102199);
        if (this.mContext != null) {
            if (this.mClient == null) {
                tMAssistantDownloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient(CLIENT_NAME);
                tMAssistantDownloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
                this.mClient = tMAssistantDownloadSDKClient;
            } else {
                tMAssistantDownloadSDKClient = this.mClient;
            }
            AppMethodBeat.o(102199);
            return tMAssistantDownloadSDKClient;
        }
        AppMethodBeat.o(102199);
        return null;
    }

    public static String about() {
        return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
    }
}
