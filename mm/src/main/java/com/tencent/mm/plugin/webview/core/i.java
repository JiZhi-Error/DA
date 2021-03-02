package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Dialog;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.share.internal.ShareConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.modelbiz.OpenWebview;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.k.j;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.model.au;
import com.tencent.mm.plugin.webview.model.av;
import com.tencent.mm.plugin.webview.model.ax;
import com.tencent.mm.plugin.webview.model.az;
import com.tencent.mm.plugin.webview.stub.WebViewStubService;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.tav.coremedia.TimeUtil;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.Assert;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000ð\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\b\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012*\u0010\u0010\u0013\u0016\u0019\u001c\u001f\"%(,/258@C\b\u0016\u0018\u0000 þ\u00012\u00020\u0001:\u0006þ\u0001ÿ\u0001\u0002B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010«\u0001\u001a\u00030¬\u00012\b\u0010­\u0001\u001a\u00030®\u0001H\u0002J\u0017\u0010¯\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0005\u0012\u00030±\u00010°\u0001H\u0002J\u0012\u0010²\u0001\u001a\u00020M2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0014J\u0014\u0010´\u0001\u001a\u00020M2\t\u0010³\u0001\u001a\u0004\u0018\u00010\u000bH\u0014J\u0011\u0010µ\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0002J\u0014\u0010¶\u0001\u001a\u00020M2\t\u0010³\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010·\u0001\u001a\u00030¬\u00012\u0007\u0010¸\u0001\u001a\u00020\u000bH\u0002J\u0014\u0010¹\u0001\u001a\u00030¬\u00012\b\u0010º\u0001\u001a\u00030®\u0001H\u0002J&\u0010»\u0001\u001a\u00030¬\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\u0007\u0010¾\u0001\u001a\u00020MH\u0016J\b\u0010¿\u0001\u001a\u00030®\u0001J\u0012\u0010À\u0001\u001a\u00020\u000b2\t\u0010³\u0001\u001a\u0004\u0018\u00010\u000bJ\u0013\u0010Á\u0001\u001a\u00030®\u00012\t\u0010Â\u0001\u001a\u0004\u0018\u00010\u000bJ\u000b\u0010Ã\u0001\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010Ä\u0001\u001a\u00020M2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0014J\n\u0010Å\u0001\u001a\u00030¬\u0001H\u0014J\n\u0010Æ\u0001\u001a\u00030¬\u0001H\u0002J\n\u0010Ç\u0001\u001a\u00030¬\u0001H\u0002J,\u0010È\u0001\u001a\u0005\u0018\u00010É\u00012\b\u0010Ê\u0001\u001a\u00030½\u00012\b\u0010Ë\u0001\u001a\u00030Ì\u00012\n\u0010Í\u0001\u001a\u0005\u0018\u00010Î\u0001H\u0014J\u0007\u0010Ï\u0001\u001a\u00020MJ\u0013\u0010Ð\u0001\u001a\u00030¬\u00012\u0007\u0010³\u0001\u001a\u00020\u000bH\u0014J4\u0010Ñ\u0001\u001a\u00030¬\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\u0016\u0010Ò\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010°\u00012\u0007\u0010Ó\u0001\u001a\u00020MH\u0016J\t\u0010Ô\u0001\u001a\u00020MH\u0014J\n\u0010Õ\u0001\u001a\u00030¬\u0001H\u0014J\n\u0010Ö\u0001\u001a\u00030¬\u0001H\u0016J\u0007\u0010×\u0001\u001a\u00020MJ\n\u0010Ø\u0001\u001a\u00030¬\u0001H\u0014J\u001f\u0010Ù\u0001\u001a\u00030¬\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\u0007\u0010³\u0001\u001a\u00020\u000bH\u0016J!\u0010Ú\u0001\u001a\u00030¬\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\t\u0010³\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J)\u0010Û\u0001\u001a\u00030¬\u00012\b\u0010¼\u0001\u001a\u00030½\u00012\u0007\u0010³\u0001\u001a\u00020\u000b2\n\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001H\u0016J\n\u0010Þ\u0001\u001a\u00030¬\u0001H\u0014J&\u0010ß\u0001\u001a\u00020M2\b\u0010à\u0001\u001a\u00030®\u00012\u0007\u0010á\u0001\u001a\u00020\u000b2\b\u0010â\u0001\u001a\u00030ã\u0001H\u0016J6\u0010ä\u0001\u001a\u00030¬\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\b\u0010å\u0001\u001a\u00030®\u00012\t\u0010æ\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010ç\u0001\u001a\u0004\u0018\u00010\u000bH\u0016J.\u0010è\u0001\u001a\u00030¬\u00012\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\n\u0010é\u0001\u001a\u0005\u0018\u00010ê\u00012\n\u0010ë\u0001\u001a\u0005\u0018\u00010ì\u0001H\u0016J\u0016\u0010í\u0001\u001a\u00030¬\u00012\n\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001H\u0016J\t\u0010ð\u0001\u001a\u00020MH\u0016J\n\u0010ñ\u0001\u001a\u00030¬\u0001H\u0014J&\u0010ò\u0001\u001a\u00020M2\b\u0010à\u0001\u001a\u00030®\u00012\u0007\u0010á\u0001\u001a\u00020\u000b2\b\u0010ó\u0001\u001a\u00030ã\u0001H\u0014J\u001c\u0010ô\u0001\u001a\u00020M2\b\u0010õ\u0001\u001a\u00030½\u00012\u0007\u0010³\u0001\u001a\u00020\u000bH\u0014J\b\u0010ö\u0001\u001a\u00030¬\u0001J\u0014\u0010÷\u0001\u001a\u00030¬\u00012\b\u0010­\u0001\u001a\u00030®\u0001H\u0002J\u0012\u0010ø\u0001\u001a\u00030¬\u00012\b\u0010ù\u0001\u001a\u00030®\u0001J\n\u0010ú\u0001\u001a\u00030¬\u0001H\u0016J\n\u0010û\u0001\u001a\u00030¬\u0001H\u0014J\n\u0010ü\u0001\u001a\u00030¬\u0001H\u0014J\u0012\u0010ý\u0001\u001a\u00020M2\u0007\u0010³\u0001\u001a\u00020\u000bH\u0002R\u0010\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0004\n\u0002\u0010\u0017R\u0010\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00020\u001fX\u0004¢\u0006\u0004\n\u0002\u0010 R\u0010\u0010!\u001a\u00020\"X\u0004¢\u0006\u0004\n\u0002\u0010#R\u0010\u0010$\u001a\u00020%X\u0004¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R\u000e\u0010*\u001a\u00020\u000bXD¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020,X\u0004¢\u0006\u0004\n\u0002\u0010-R\u0010\u0010.\u001a\u00020/X\u0004¢\u0006\u0004\n\u0002\u00100R\u0010\u00101\u001a\u000202X\u0004¢\u0006\u0004\n\u0002\u00103R\u0010\u00104\u001a\u000205X\u0004¢\u0006\u0004\n\u0002\u00106R\u0010\u00107\u001a\u000208X\u0004¢\u0006\u0004\n\u0002\u00109R\u001b\u0010:\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b;\u0010<R\u0010\u0010?\u001a\u00020@X\u0004¢\u0006\u0004\n\u0002\u0010AR\u0010\u0010B\u001a\u00020CX\u0004¢\u0006\u0004\n\u0002\u0010DR\u0010\u0010E\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R!\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8TX\u0002¢\u0006\f\n\u0004\bK\u0010>\u001a\u0004\bI\u0010JR\u001b\u0010L\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bP\u0010>\u001a\u0004\bN\u0010OR\u000e\u0010Q\u001a\u00020MXD¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bS\u0010>\u001a\u0004\bR\u0010OR\u0010\u0010T\u001a\u0004\u0018\u00010UX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010V\u001a\u00020M8BX\u0002¢\u0006\f\n\u0004\bX\u0010>\u001a\u0004\bW\u0010OR\u000e\u0010Y\u001a\u00020ZX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\\X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u000e¢\u0006\u0002\n\u0000R(\u0010e\u001a\u0004\u0018\u00010\u000b2\b\u0010d\u001a\u0004\u0018\u00010\u000b@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010<\"\u0004\bg\u0010hR\u001c\u0010i\u001a\n j*\u0004\u0018\u00010\u000b0\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\bk\u0010<R\u001b\u0010l\u001a\u00020m8BX\u0002¢\u0006\f\n\u0004\bp\u0010>\u001a\u0004\bn\u0010oR\u001b\u0010q\u001a\u00020r8BX\u0002¢\u0006\f\n\u0004\bu\u0010>\u001a\u0004\bs\u0010tR\u0014\u0010v\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\bw\u0010<R\u001b\u0010x\u001a\u00020y8BX\u0002¢\u0006\f\n\u0004\b|\u0010>\u001a\u0004\bz\u0010{R&\u0010}\u001a\n\u0012\u0006\b\u0001\u0012\u000200~8TX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010>\u001a\u0006\b\u0001\u0010\u0001R\u0013\u0010\u0001\u001a\u00020\u000b8F¢\u0006\u0007\u001a\u0005\b\u0001\u0010<R\u0016\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001X\u0004¢\u0006\u0002\n\u0000R$\u0010\u0001\u001a\u00070\u0001R\u00020\u00008BX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010>\u001a\u0006\b\u0001\u0010\u0001R\u0015\u0010\u0001\u001a\u00030\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u0005\u0018\u00010 \u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0000\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0015\u0010§\u0001\u001a\u00030¨\u0001¢\u0006\n\n\u0000\u001a\u0006\b©\u0001\u0010ª\u0001¨\u0006\u0002"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewController;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "webviewReportMgr", "Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;)V", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "ActivityJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1;", "AddFriendHandler", "com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1;", "CloseHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1;", "CriticalUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1;", "DeepLinkHandler", "com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1;", "FeedbackJumpHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1;", "FreeWifiConnectHandler", "com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1;", "GetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1;", "GoProfileHandler", "com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1;", "JS_API_FILE", "ManualUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1;", "OauthHandler", "com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1;", "ReaderShareHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1;", "RecommendUpdateHandler", "com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1;", "SDKOpenWebViewResultHandler", "com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1;", "TAG", "getTAG", "()Ljava/lang/String;", "TAG$delegate", "Lkotlin/Lazy;", "ViewImageGetHtmlHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1;", "ViewImageHandler", "com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1;", "currentImageViewUrl", "deepLinkPermission", "", "fileUrlWhiteList", "getFileUrlWhiteList", "()Ljava/util/Set;", "fileUrlWhiteList$delegate", "finishIfLoadFailed", "", "getFinishIfLoadFailed", "()Z", "finishIfLoadFailed$delegate", "isBridgeByIframe", "isFromLoginHistory", "isFromLoginHistory$delegate", "mLoadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "neverBlockLocalRequest", "getNeverBlockLocalRequest", "neverBlockLocalRequest$delegate", "oauthDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "oauthOnSceneEndDelegate", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "getOauthOnSceneEndDelegate", "()Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "setOauthOnSceneEndDelegate", "(Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;)V", "pageEndTime", "pluginClientProxy", "Lcom/tencent/luggage/xweb_ext/extendplugin/proxy/IExtendPluginClientProxy;", "<set-?>", "previousUrl", "getPreviousUrl", "setPreviousUrl", "(Ljava/lang/String;)V", "publisherId", "kotlin.jvm.PlatformType", "getPublisherId", "routeUrlMap", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "getRouteUrlMap", "()Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "routeUrlMap$delegate", "sceneCallbacker", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "getSceneCallbacker", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "sceneCallbacker$delegate", "sentUsername", "getSentUsername", "sslErrorHandler", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "getSslErrorHandler", "()Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "sslErrorHandler$delegate", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "stubService$delegate", "title", "getTitle", "uploadUrlSet", "", "urlHandlerList", "", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "visitInfoReport", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "getVisitInfoReport", "()Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "visitInfoReport$delegate", "webViewFloatBallInfo", "Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "getWebViewFloatBallInfo", "()Lcom/tencent/mm/plugin/webview/ui/tools/floatball/WebViewFloatBallInfo;", "webViewMenuHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "getWebViewMenuHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;", "setWebViewMenuHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewMenuHelper;)V", "webViewUIProxyImpl", "Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "getWebViewUIProxyImpl", "()Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;", "setWebViewUIProxyImpl", "(Lcom/tencent/mm/plugin/webview/ui/tools/video/samelayer/WebViewUIProxyImpl;)V", "webViewUIStyleHelper", "Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "getWebViewUIStyleHelper", "()Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;", "setWebViewUIStyleHelper", "(Lcom/tencent/mm/plugin/webview/ui/tools/WebViewUIStyleHelper;)V", "getWebviewReportMgr", "()Lcom/tencent/mm/plugin/webview/model/WebviewReporterManager;", "webviewResourceInterrupter", "Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "getWebviewResourceInterrupter", "()Lcom/tencent/mm/plugin/webview/model/WebViewResourceInterrupter;", "addSceneEnd", "", "type", "", "buildExtParams", "", "", "canHandleUrl", "url", "cancelReport", "createHandlerList", "dealCustomScheme", "doJumpEmotionDetailUrlScene", "fullUrl", "doUpdate", "updateType", "doUpdateVisitedHistory", "view", "Lcom/tencent/xweb/WebView;", "isReload", "getA8KeyScene", "getCachedAppId", "getScene", ch.COL_USERNAME, "getWebViewPluginClientProxy", "handleUrl", "initEnviroment", "initUrlHandler", "initializePayChannel", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webview", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "bundle", "Landroid/os/Bundle;", "isEnterpriseWebBrand", "jumpToActivity", "loadUrl", "httpHeaders", "withoutCache", "needSyncGetA8Key", "onBinded", "onDestroy", "onFloatBallDestroy", "onJsReady", "onLoadResource", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onProcessResult", "reason", "reqUrl", "response", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "onReceivedError", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "description", "failingUrl", "onReceivedSslError", "handler", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "onServiceDisconnected", "onStartLoad", "overrideProcessResult", "resp", "overrideUrl", "webView", "releaseWebView", "removeSceneEnd", "requestSetFontSize", "fontSize", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "startSearchContact", "Companion", "SceneEndCallbacker", "VisitInfoReport", "plugin-webview_release"})
public class i extends BaseWebViewController {
    public static final d IMt = new d((byte) 0);
    private final kotlin.f ILC;
    public com.tencent.mm.plugin.webview.ui.tools.j ILD;
    public com.tencent.mm.plugin.webview.ui.tools.o ILE;
    public com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h ILF;
    public final com.tencent.mm.plugin.webview.ui.tools.floatball.c ILG;
    private final kotlin.f ILH;
    private final kotlin.f ILI;
    private final kotlin.f ILJ;
    private final kotlin.f ILK;
    public final ar ILL;
    private final kotlin.f ILM;
    private final kotlin.f ILN;
    public String ILO;
    private final kotlin.f ILP;
    private final String ILQ;
    private final Set<String> ILR;
    private final kotlin.f ILS;
    private com.tencent.mm.ui.base.q ILT;
    private final ag.c ILU;
    ag.a ILV;
    private long ILW;
    private final List<com.tencent.mm.plugin.webview.d.d.a> ILX;
    private final l ILY;
    private final j ILZ;
    private final e IMa;
    private final k IMb;
    private final n IMc;
    private final a IMd;
    private String IMe;
    private final boolean IMf;
    private final s IMg;
    private final C1946i IMh;
    private final r IMi;
    private final m IMj;
    private final g IMk;
    private final b IMl;
    private final o IMm;
    private final c IMn;
    private long IMo;
    private final f IMp;
    private final h IMq;
    private com.tencent.luggage.xweb_ext.extendplugin.b.c IMr;
    public final az IMs;
    private final kotlin.f pFA;

    static {
        AppMethodBeat.i(210280);
        AppMethodBeat.o(210280);
    }

    private final t fZS() {
        AppMethodBeat.i(210238);
        t tVar = (t) this.ILK.getValue();
        AppMethodBeat.o(210238);
        return tVar;
    }

    private final com.tencent.mm.plugin.webview.ui.tools.c fZT() {
        AppMethodBeat.i(210241);
        com.tencent.mm.plugin.webview.ui.tools.c cVar = (com.tencent.mm.plugin.webview.ui.tools.c) this.ILN.getValue();
        AppMethodBeat.o(210241);
        return cVar;
    }

    private final com.tencent.mm.plugin.webview.modeltools.n fZU() {
        AppMethodBeat.i(210244);
        com.tencent.mm.plugin.webview.modeltools.n nVar = (com.tencent.mm.plugin.webview.modeltools.n) this.ILP.getValue();
        AppMethodBeat.o(210244);
        return nVar;
    }

    private final p fZW() {
        AppMethodBeat.i(210264);
        p pVar = (p) this.ILS.getValue();
        AppMethodBeat.o(210264);
        return pVar;
    }

    private final String getTAG() {
        AppMethodBeat.i(210232);
        String str = (String) this.pFA.getValue();
        AppMethodBeat.o(210232);
        return str;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final Class<? extends Service> fZp() {
        AppMethodBeat.i(210233);
        Class<? extends Service> cls = (Class) this.ILC.getValue();
        AppMethodBeat.o(210233);
        return cls;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final Set<String> fZq() {
        AppMethodBeat.i(210235);
        Set<String> set = (Set) this.ILH.getValue();
        AppMethodBeat.o(210235);
        return set;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u000fJ\u001e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bR\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "", "controller", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Lcom/tencent/mm/plugin/webview/core/WebViewController;Lcom/tencent/mm/plugin/webview/core/WebViewController;)V", "clickTimestamp", "", "fromScene", "", "mCurUrl", "", "networkType", "refererUrl", "userAgent", "doReport", "", "targetUrl", "startTime", "targetAction", "initWebViewType", "report", "plugin-webview_release"})
    public final class t {
        private final i IMH;
        private volatile String IMK = "";
        private volatile String IML = "";
        final /* synthetic */ i IMu;
        private int fromScene = this.IMH.getIntent().getIntExtra("from_scence", 0);
        private long mRS;
        private int networkType;
        private String userAgent;

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/kt/CommonKt$idle$1", "Landroid/os/MessageQueue$IdleHandler;", "queueIdle", "", "libktcomm_release"})
        public static final class a implements MessageQueue.IdleHandler {
            final /* synthetic */ t IMM;
            final /* synthetic */ String IMN;
            final /* synthetic */ long IMO;
            final /* synthetic */ int IMP = 1;

            public a(t tVar, String str, long j2) {
                this.IMM = tVar;
                this.IMN = str;
                this.IMO = j2;
            }

            public final boolean queueIdle() {
                AppMethodBeat.i(210202);
                Looper.myQueue().removeIdleHandler(this);
                this.IMM.r(this.IMN, this.IMO, this.IMP);
                AppMethodBeat.o(210202);
                return false;
            }
        }

        public t(i iVar, i iVar2) {
            kotlin.g.b.p.h(iVar2, "controller");
            this.IMu = iVar;
            AppMethodBeat.i(210205);
            this.IMH = iVar2;
            com.tencent.xweb.z settings = this.IMH.pGj.getSettings();
            kotlin.g.b.p.g(settings, "controller.viewWV.settings");
            String userAgentString = settings.getUserAgentString();
            kotlin.g.b.p.g(userAgentString, "controller.viewWV.settings.userAgentString");
            this.userAgent = userAgentString;
            AppMethodBeat.o(210205);
        }

        private void gaa() {
            Context context;
            int i2;
            AppMethodBeat.i(210203);
            Context context2 = this.IMH.getContext();
            if (!(context2 instanceof ContextWrapper)) {
                context2 = null;
            }
            ContextWrapper contextWrapper = (ContextWrapper) context2;
            if (contextWrapper == null || (context = contextWrapper.getApplicationContext()) == null) {
                context = this.IMH.getContext();
            }
            if (NetStatusUtil.isConnected(context)) {
                if (NetStatusUtil.isWifi(context)) {
                    i2 = 1;
                } else if (NetStatusUtil.is5G(context)) {
                    i2 = 5;
                } else if (NetStatusUtil.is4G(context)) {
                    i2 = 4;
                } else if (NetStatusUtil.is3G(context)) {
                    i2 = 3;
                } else if (NetStatusUtil.is2G(context)) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                this.networkType = i2;
                Log.i(i.a(this.IMu), "get networkType " + this.networkType);
            }
            AppMethodBeat.o(210203);
        }

        public final void r(String str, long j2, int i2) {
            String str2;
            AppMethodBeat.i(210204);
            kotlin.g.b.p.h(str, "targetUrl");
            gaa();
            String aXD = this.IMH.aXD(this.IML);
            if (this.fromScene != 0) {
                this.IMK = " ";
            }
            boolean gtG = this.IMH.mHi.gdI().gtG();
            Log.d(i.a(this.IMu), "webpageVisitInfoReport enableReportPageEvent %s", Boolean.valueOf(gtG));
            if (this.mRS > 0 && this.IMu.ILW > this.mRS && j2 > this.IMu.ILW && !TextUtils.isEmpty(aXD) && gtG) {
                long j3 = this.IMu.ILW - this.mRS;
                long j4 = j2 - this.IMu.ILW;
                Log.d(i.a(this.IMu), "report(%s), clickTimestamp : %d, appID : %s, usedTime : %s, stayTime : %s, networkType : %s, userAgent : %s, url : %s, sessionID : %s, targetAction : %s, targetUrl : %s,scene : %s, refererUrl : %s", 13376, Long.valueOf(this.mRS), aXD, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(this.networkType), this.userAgent, this.IML, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(i2), str, Integer.valueOf(this.fromScene), this.IMK);
                String str3 = "";
                String str4 = "";
                String str5 = "";
                try {
                    str3 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.userAgent), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    str4 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.IML), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    str5 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(str), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                    str2 = com.tencent.mm.compatible.util.q.encode(Util.nullAsNil(this.IMK), MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e2) {
                    Log.printErrStackTrace(i.a(this.IMu), e2, "", new Object[0]);
                    str2 = "";
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(13376, Long.valueOf(this.mRS), aXD, Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(this.networkType), str3, str4, com.tencent.mm.plugin.luckymoney.a.d.sessionId, Integer.valueOf(i2), str5, Integer.valueOf(this.fromScene), str2);
                this.fromScene = 0;
            }
            if (i2 == 1) {
                this.IMK = this.IML;
                this.IML = str;
                this.mRS = j2;
            }
            AppMethodBeat.o(210204);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"getNetWorkTypeName", "", "context", "Landroid/content/Context;", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.b<Context, String> {
        public static final ac IMS = new ac();

        static {
            AppMethodBeat.i(210221);
            AppMethodBeat.o(210221);
        }

        ac() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(Context context) {
            AppMethodBeat.i(210219);
            String hQ = hQ(context);
            AppMethodBeat.o(210219);
            return hQ;
        }

        public static String hQ(Context context) {
            AppMethodBeat.i(210220);
            kotlin.g.b.p.h(context, "context");
            if (NetStatusUtil.isWifi(context)) {
                AppMethodBeat.o(210220);
                return "wifi";
            } else if (NetStatusUtil.is5G(context)) {
                AppMethodBeat.o(210220);
                return "5g";
            } else if (NetStatusUtil.is4G(context)) {
                AppMethodBeat.o(210220);
                return "4g";
            } else if (NetStatusUtil.is3G(context)) {
                AppMethodBeat.o(210220);
                return "3g";
            } else if (NetStatusUtil.is2G(context)) {
                AppMethodBeat.o(210220);
                return "2g";
            } else {
                AppMethodBeat.o(210220);
                return "none";
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"dnsIps", "", "host", "invoke"})
    static final class ad extends kotlin.g.b.q implements kotlin.g.a.b<String, String> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ad(i iVar) {
            super(1);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(String str) {
            AppMethodBeat.i(210222);
            String aXM = aXM(str);
            AppMethodBeat.o(210222);
            return aXM;
        }

        public final String aXM(String str) {
            AppMethodBeat.i(210223);
            StringBuilder sb = new StringBuilder();
            try {
                InetAddress[] allByName = InetAddress.getAllByName(str);
                if (allByName != null && allByName.length > 0) {
                    for (InetAddress inetAddress : allByName) {
                        kotlin.g.b.p.g(inetAddress, "inetAddressArr[i]");
                        sb.append(inetAddress.getHostAddress());
                        sb.append(";");
                    }
                }
                String sb2 = sb.toString();
                AppMethodBeat.o(210223);
                return sb2;
            } catch (UnknownHostException e2) {
                Log.printErrStackTrace(i.a(this.IMu), e2, "dnsIps", new Object[0]);
                AppMethodBeat.o(210223);
                return null;
            }
        }
    }

    public static final /* synthetic */ String a(i iVar) {
        AppMethodBeat.i(210281);
        String tag = iVar.getTAG();
        AppMethodBeat.o(210281);
        return tag;
    }

    public static final /* synthetic */ p e(i iVar) {
        AppMethodBeat.i(210283);
        p fZW = iVar.fZW();
        AppMethodBeat.o(210283);
        return fZW;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.webview.f.a, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final /* bridge */ /* synthetic */ boolean b(int i2, String str, bhj bhj) {
        AppMethodBeat.i(210252);
        boolean b2 = b(i2, str, bhj);
        AppMethodBeat.o(210252);
        return b2;
    }

    private /* synthetic */ i(MMWebView mMWebView, az azVar, BaseWebViewController.c cVar) {
        this(mMWebView, azVar, cVar, null, null);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(MMWebView mMWebView, az azVar, BaseWebViewController.c cVar, Set<String> set, com.tencent.mm.plugin.webview.d.e eVar) {
        super(mMWebView, cVar, set, eVar);
        kotlin.g.b.p.h(mMWebView, "viewWV");
        kotlin.g.b.p.h(azVar, "webviewReportMgr");
        kotlin.g.b.p.h(cVar, "options");
        AppMethodBeat.i(210277);
        this.IMs = azVar;
        this.pFA = kotlin.g.ah(new q(this));
        this.ILC = kotlin.g.ah(aj.IMX);
        this.ILG = new com.tencent.mm.plugin.webview.ui.tools.floatball.c();
        this.ILH = kotlin.g.ah(new v(this));
        this.ILI = kotlin.g.ah(new x(this));
        this.ILJ = kotlin.g.ah(new w(this));
        this.ILK = kotlin.g.ah(new ak(this));
        this.ILL = new ar(getContext());
        this.ILM = kotlin.g.ah(new y(this));
        this.ILN = kotlin.g.ah(new ai(mMWebView));
        this.ILP = kotlin.g.ah(ag.IMW);
        this.ILQ = "file:///android_asset/jsapi/wxjs.js";
        this.ILR = new HashSet();
        this.ILS = kotlin.g.ah(new ah(this));
        this.ILU = new z(this, mMWebView);
        this.ILV = new aa(this);
        this.ILX = new ArrayList();
        this.ILY = new l(this);
        this.ILZ = new j(this);
        this.IMa = new e(this);
        this.IMb = new k(this);
        this.IMc = new n(this);
        this.IMd = new a(this);
        this.IMf = true;
        this.IMg = new s(this, mMWebView);
        this.IMh = new C1946i(this);
        this.IMi = new r(this);
        this.IMj = new m(this, mMWebView);
        this.IMk = new g(this);
        this.IMl = new b(this);
        this.IMm = new o(this);
        this.IMn = new c(this);
        this.IMp = new f(this, mMWebView);
        this.IMq = new h(this);
        AppMethodBeat.o(210277);
    }

    public /* synthetic */ i(MMWebView mMWebView) {
        this(mMWebView, new az(), new BaseWebViewController.c(null, false, false, false, false, 63), (byte) 0);
        AppMethodBeat.i(210279);
        AppMethodBeat.o(210279);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public i(MMWebView mMWebView, az azVar, BaseWebViewController.c cVar, byte b2) {
        this(mMWebView, azVar, cVar);
        kotlin.g.b.p.h(mMWebView, "viewWV");
        kotlin.g.b.p.h(azVar, "webviewReportMgr");
        kotlin.g.b.p.h(cVar, "options");
        AppMethodBeat.i(210278);
        AppMethodBeat.o(210278);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void fZC() {
        AppMethodBeat.i(210234);
        super.fZC();
        fZT().aG(this.pGj.getActivityContextIfHas());
        Context activityContextIfHas = this.pGj.getActivityContextIfHas();
        if (!(activityContextIfHas instanceof Activity)) {
            activityContextIfHas = null;
        }
        Activity activity = (Activity) activityContextIfHas;
        if (activity != null) {
            Intent intent = activity.getIntent();
            kotlin.g.b.p.g(intent, "it.intent");
            setIntent(intent);
            AppMethodBeat.o(210234);
            return;
        }
        AppMethodBeat.o(210234);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public void cpc() {
        AppMethodBeat.i(210239);
        a(new av());
        super.cpc();
        AppMethodBeat.o(210239);
    }

    @Override // com.tencent.xweb.ac
    public final void h(WebView webView, String str) {
        AppMethodBeat.i(210240);
        kotlin.g.b.p.h(str, "url");
        Log.i(getTAG(), "edw onLoadResource opt, url = ".concat(String.valueOf(str)));
        if (aXC(str)) {
            Log.f(getTAG(), "onLoadResource, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            super.h(webView, str);
            AppMethodBeat.o(210240);
            return;
        }
        this.IMs.gdb().aZf(str);
        super.h(webView, str);
        AppMethodBeat.o(210240);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ae implements Runnable {
        final /* synthetic */ String ILv;
        final /* synthetic */ ad IMT;
        final /* synthetic */ String IMU;
        final /* synthetic */ int tyb;

        ae(String str, int i2, ad adVar, String str2) {
            this.ILv = str;
            this.tyb = i2;
            this.IMT = adVar;
            this.IMU = str2;
        }

        public final void run() {
            AppMethodBeat.i(210224);
            com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
            ac acVar = ac.IMS;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            hVar.a(17082, this.ILv, Integer.valueOf(this.tyb), ac.hQ(context), this.IMT.aXM(this.IMU));
            AppMethodBeat.o(210224);
        }
    }

    /* access modifiers changed from: protected */
    public boolean aiy(String str) {
        return false;
    }

    @Override // com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void b(WebView webView, String str, Bitmap bitmap) {
        Parcelable parcelable;
        AppMethodBeat.i(210245);
        kotlin.g.b.p.h(webView, "view");
        kotlin.g.b.p.h(str, "url");
        super.b(webView, str, bitmap);
        this.IKa.bN("onPageStarted", System.currentTimeMillis());
        com.tencent.mm.plugin.webview.model.a.a(this.pGj, str);
        if (aiy(str)) {
            AppMethodBeat.o(210245);
            return;
        }
        if (!this.pGj.supportFeature(2006)) {
            getJsapi().gbj();
        }
        com.tencent.mm.plugin.webview.k.k.j(str, getContext());
        Log.i(getTAG(), "edw onPageStarted opt, url = ".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 0, 1, false);
        com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 0);
        if (CrashReportFactory.hasDebuger() && kotlin.g.b.p.j("http://www.dktest-mmcrash.com/", str)) {
            Assert.assertTrue("test errlog in tools " + new SimpleDateFormat(TimeUtil.YYYY2MM2DD_HH1MM1SS).format(new Date()), false);
        }
        this.ILO = this.IJM;
        long nowSecond = Util.nowSecond();
        t fZS = fZS();
        kotlin.g.b.p.h(str, "targetUrl");
        Looper.myQueue().addIdleHandler(new t.a(fZS, str, nowSecond));
        this.IMs.gdc().IZG = this.ILO;
        this.IJM = str;
        com.tencent.mm.plugin.webview.ui.tools.l.Jhd.cV(str);
        Log.d(getTAG(), "onPageStarted preUrl : %s, curUrl : %s.", this.ILO, this.IJM);
        if (aXC(str)) {
            Log.f(getTAG(), "onPageStarted, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            AppMethodBeat.o(210245);
            return;
        }
        fZU().add(str);
        this.IMs.gda().cU(bLC(), fZR()).aZh(str);
        Bundle bundle = (Bundle) getIntent().getParcelableExtra("jsapiargs");
        if (!(bundle == null || (parcelable = bundle.getParcelable("KSnsAdTag")) == null || !(parcelable instanceof SnsAdClick))) {
            String string = bundle.getString("KAnsUxInfo", "");
            this.IMs.gdl().Bfh = (SnsAdClick) parcelable;
            au gdl = this.IMs.gdl();
            kotlin.g.b.p.g(string, "uxInfo");
            gdl.U(str, AppEventsConstants.EVENT_PARAM_VALUE_NO, String.valueOf(System.currentTimeMillis()), string);
            this.IMs.gdl().report();
        }
        com.tencent.mm.plugin.webview.ui.tools.n nVar = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
        com.tencent.mm.plugin.webview.ui.tools.n.a(getIntent(), str, false);
        AppMethodBeat.o(210245);
    }

    @Override // com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public void b(WebView webView, String str) {
        Parcelable parcelable;
        AppMethodBeat.i(210247);
        super.b(webView, str);
        this.IKa.bN("onPageFinished", System.currentTimeMillis());
        com.tencent.mm.plugin.webview.model.a.a(this.pGj, str);
        if (aiy(str)) {
            AppMethodBeat.o(210247);
            return;
        }
        Log.i(getTAG(), "edw onPageFinished opt, url = %s", str);
        this.IMs.gdk().cW(str);
        com.tencent.mm.plugin.webview.ui.tools.l.Jhd.LZ();
        fZU().add(str);
        boolean booleanExtra = getIntent().getBooleanExtra("shouldForceViewPort", false);
        Log.d(getTAG(), "hy: shouldForceViewPort: ".concat(String.valueOf(booleanExtra)));
        if (booleanExtra) {
            String stringExtra = getIntent().getStringExtra("view_port_code");
            if (webView == null) {
                kotlin.g.b.p.hyc();
            }
            webView.evaluateJavascript(stringExtra, null);
        }
        if (str == null) {
            kotlin.g.b.p.hyc();
        }
        if (aXC(str)) {
            Log.f(getTAG(), "onPageFinished, canLoadUrl fail, url = ".concat(String.valueOf(str)));
            AppMethodBeat.o(210247);
        } else if (kotlin.g.b.p.j(str, this.ILQ)) {
            Log.i(getTAG(), "onPageFinished, js is finished loaded");
            AppMethodBeat.o(210247);
        } else {
            this.IMs.gda().aZi(str);
            this.IMs.gdb().aZg(str);
            this.IMs.gde().report();
            Bundle bundle = (Bundle) getIntent().getParcelableExtra("jsapiargs");
            if (!(bundle == null || (parcelable = bundle.getParcelable("KSnsAdTag")) == null || !(parcelable instanceof SnsAdClick))) {
                String string = bundle.getString("KAnsUxInfo", "");
                this.IMs.gdl().Bfh = (SnsAdClick) parcelable;
                au gdl = this.IMs.gdl();
                kotlin.g.b.p.g(string, "uxInfo");
                gdl.U(str, "1", String.valueOf(System.currentTimeMillis()), string);
                this.IMs.gdl().report();
            }
            com.tencent.mm.plugin.webview.ui.tools.n nVar = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
            com.tencent.mm.plugin.webview.ui.tools.n.a(getIntent(), str, true);
            this.ILW = Util.nowSecond();
            AppMethodBeat.o(210247);
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        AppMethodBeat.i(210248);
        kotlin.g.b.p.h(webView, "webview");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (isStarted() && afI(this.IKj)) {
            WebResourceResponse a2 = this.ILL.a(webResourceRequest.getUrl().toString(), webResourceRequest, !((Boolean) this.ILM.getValue()).booleanValue(), fZs());
            if (a2 != null) {
                AppMethodBeat.o(210248);
                return a2;
            }
        }
        WebResourceResponse b2 = super.b(webView, webResourceRequest, bundle);
        AppMethodBeat.o(210248);
        return b2;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x024c, code lost:
        if (com.tencent.luggage.h.c.A(r14, r0) != false) goto L_0x024e;
     */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m(com.tencent.xweb.WebView r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 763
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.i.m(com.tencent.xweb.WebView, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void cpR() {
        AppMethodBeat.i(210250);
        int i2 = 2;
        try {
            if (fZs().gdW()) {
                i2 = this.IKM.IKV ? com.tencent.mm.plugin.webview.k.f.a(getContext(), fZs(), coX()) : com.tencent.mm.plugin.webview.k.f.id(getContext());
            }
        } catch (Exception e2) {
            Log.e(getTAG(), "onLoadJsApiFinished, ex = " + e2.getMessage());
        }
        afK(i2);
        String url = this.pGj.getUrl();
        if (!Util.isNullOrNil(url)) {
            Set<String> set = this.ILR;
            if (url == null) {
                kotlin.g.b.p.hyc();
            }
            if (set.add(url)) {
                GeneralControlWrapper gdI = this.mHi.gdI();
                kotlin.g.b.p.g(gdI, "wvPerm.genCtrl");
                if (gdI.gtE()) {
                    getJsapi().gbe();
                }
                if (gdI.gtF()) {
                    getJsapi().yZ(false);
                    AppMethodBeat.o(210250);
                    return;
                } else if (this.ILL.aYR(url)) {
                    getJsapi().yZ(true);
                }
            }
        }
        super.cpR();
        AppMethodBeat.o(210250);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean b(int i2, String str, bhj bhj) {
        long j2;
        AppMethodBeat.i(210251);
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(bhj, "response");
        aey aey = bhj.LRP;
        if (aey != null) {
            j2 = aey.Lqi;
        } else {
            j2 = -1;
        }
        this.IMo = j2;
        boolean isX5Kernel = this.pGj.getIsX5Kernel();
        String str2 = bhj.LRH;
        kotlin.g.b.p.g(str2, "response.FullURL");
        az.aU(isX5Kernel, kotlin.n.n.J(str2, HttpWrapperBase.PROTOCAL_HTTPS, false));
        this.IMs.gcZ().cM(str, true);
        this.IMs.gdb().cT(com.tencent.mm.plugin.webview.ui.tools.game.h.ehX, fZR()).aZe(bhj.LRH);
        boolean b2 = super.b(i2, str, bhj);
        AppMethodBeat.o(210251);
        return b2;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean a(int i2, String str, bhj bhj) {
        boolean z2;
        AppMethodBeat.i(210253);
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(bhj, "resp");
        int i3 = bhj.KCD;
        String str2 = bhj.LRH;
        switch (i3) {
            case 3:
                Log.i(getTAG(), "getA8key-app: ".concat(String.valueOf(str2)));
                String str3 = str2;
                if (str3 == null || str3.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    Log.e(getTAG(), "getA8key-app, fullUrl is null");
                    AppMethodBeat.o(210253);
                    return false;
                }
                aXH(str2);
                AppMethodBeat.o(210253);
                return true;
            case 4:
                kotlin.g.b.p.g(str2, "fullUrl");
                aXG(str2);
                AppMethodBeat.o(210253);
                return true;
            case 20:
                kotlin.g.b.p.g(str2, "fullUrl");
                fZX();
                Bundle bundle = new Bundle();
                bundle.putString("emoji_store_jump_url", str2);
                bundle.putInt("webview_binder_id", fZW().fZu());
                try {
                    fZs().x(com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX, bundle);
                } catch (Exception e2) {
                    Log.w(getTAG(), "startSearchContact, ex = " + e2.getMessage());
                }
                AppMethodBeat.o(210253);
                return true;
            default:
                boolean a2 = super.a(i2, str, bhj);
                AppMethodBeat.o(210253);
                return a2;
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void fZG() {
        AppMethodBeat.i(210254);
        super.fZG();
        com.tencent.mm.plugin.webview.i.b.gdQ();
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().a(this.IKa);
        }
        com.tencent.mm.plugin.webview.k.j jVar = this.IKa;
        MMWebView mMWebView = this.pGj;
        ab abVar = new ab(this);
        kotlin.g.b.p.h(mMWebView, "webView");
        kotlin.g.b.p.h(abVar, "callback");
        mMWebView.evaluateJavascript("JSON.stringify(Object.assign({timing: performance && performance.timing}, {paint:{'firstContentfulPaint':(function(p){return p[0] && parseInt(p[0].startTime + performance.timeOrigin)})(performance.getEntriesByName('first-contentful-paint'))}}))", new j.b(jVar, abVar));
        AppMethodBeat.o(210254);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void a(com.tencent.mm.plugin.webview.stub.e eVar) {
        AppMethodBeat.i(210255);
        String tag = getTAG();
        Object[] objArr = new Object[1];
        objArr[0] = Boolean.valueOf(eVar == null);
        Log.i(tag, "onServiceConnected, invoker == null ? %b", objArr);
        if (eVar == null) {
            Log.f(getTAG(), "service connect success, while invoker is null");
            onFinish();
            AppMethodBeat.o(210255);
            return;
        }
        try {
            eVar.a(fZW(), fZW().fZu());
        } catch (Exception e2) {
            Log.e(getTAG(), "addCallback fail, ex = %s", e2.getMessage());
        }
        super.a(eVar);
        AppMethodBeat.o(210255);
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final boolean fZB() {
        boolean z2;
        AppMethodBeat.i(210256);
        Log.i(getTAG(), "edw onServiceDisconnected");
        Iterator<T> it = this.ICu.iterator();
        while (true) {
            if (it.hasNext()) {
                if (it.next().gah()) {
                    z2 = true;
                    break;
                }
            } else {
                z2 = false;
                break;
            }
        }
        if (!z2) {
            Log.i(getTAG(), "maybe mm process crash, try rebind service");
            AppMethodBeat.o(210256);
            return true;
        }
        boolean fZB = super.fZB();
        AppMethodBeat.o(210256);
        return fZB;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void ePr() {
        Bundle bundle;
        int i2;
        AppMethodBeat.i(210257);
        if (fZD()) {
            Log.e(getTAG(), "onBinded call when activity has been finished");
            AppMethodBeat.o(210257);
            return;
        }
        Log.i(getTAG(), "Abe-Debug onPostBindedStart");
        this.IKa.bN("onPostBindedStart", System.currentTimeMillis());
        com.tencent.mm.plugin.webview.ui.tools.l.Jhd.b(fZs());
        String stringExtra = getIntent().getStringExtra("ad_info");
        if (stringExtra != null) {
            com.tencent.mm.plugin.webview.ui.tools.l lVar = com.tencent.mm.plugin.webview.ui.tools.l.Jhd;
            kotlin.g.b.p.g(lVar, "WebViewReportUtil.INSTANCE");
            lVar.setTraceId(stringExtra);
        }
        this.IKa.bN("onJSAPIStart", System.currentTimeMillis());
        Bundle bundleExtra = getIntent().getBundleExtra("jsapiargs");
        if (bundleExtra == null) {
            bundle = new Bundle();
        } else {
            bundle = bundleExtra;
        }
        bundle.putInt("key_download_restrict", getIntent().getIntExtra("key_download_restrict", 0));
        bundle.putString("key_function_id", getIntent().getStringExtra("key_function_id"));
        Log.i(getTAG(), "KDownloadRestrict = %d, KFunctionID = %s", Integer.valueOf(bundle.getInt("key_download_restrict", 0)), bundle.getString("key_function_id", ""));
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("jsapiargs", bundle);
        bundle2.putCharSequence("bizofstartfrom", getIntent().getStringExtra("bizofstartfrom"));
        bundle2.putBundle("startwebviewparams", getIntent().getBundleExtra("startwebviewparams"));
        bundle2.putInt("screen_orientation", getScreenOrientation());
        try {
            fZs().a(20, bundle2, fZu());
        } catch (RemoteException e2) {
            Log.e(getTAG(), "postBinded, invoke AC_SET_INITIAL_ARGS, ex = " + e2.getMessage());
        }
        String stringExtra2 = getIntent().getStringExtra("geta8key_username");
        int intExtra = getIntent().getIntExtra("preChatTYPE", 0);
        String stringExtra3 = getIntent().getStringExtra("srcUsername");
        long longExtra = getIntent().getLongExtra("message_id", 0);
        int intExtra2 = getIntent().getIntExtra("message_index", 0);
        String stringExtra4 = getIntent().getStringExtra("KsnsViewId");
        String stringExtra5 = getIntent().getStringExtra("KPublisherId");
        String stringExtra6 = getIntent().getStringExtra("KAppId");
        String stringExtra7 = getIntent().getStringExtra("pre_username");
        String stringExtra8 = getIntent().getStringExtra("expid_str");
        String string = bundle.getString("key_snsad_statextstr");
        ax gdc = this.IMs.gdc();
        gdc.username = stringExtra2;
        gdc.IZH = intExtra;
        gdc.edo = coX();
        gdc.IZD = intExtra2;
        gdc.scene = aXI(stringExtra2);
        gdc.IZC = longExtra;
        gdc.IZE = new com.tencent.mm.b.p(longExtra).toString();
        gdc.ISp = stringExtra3;
        gdc.IZB = stringExtra4;
        gdc.iAh = stringExtra5;
        gdc.appId = stringExtra6;
        gdc.IZF = stringExtra7;
        gdc.IZG = this.ILO;
        gdc.statExtStr = string;
        String title = getTitle();
        if (title == null) {
            title = "";
        }
        gdc.title = title;
        gdc.fRa = stringExtra8;
        String stringExtra9 = getIntent().getStringExtra("share_report_pre_msg_desc");
        if (stringExtra9 == null) {
            stringExtra9 = "";
        }
        if (stringExtra9 == null) {
            stringExtra9 = "";
        }
        gdc.desc = stringExtra9;
        com.tencent.mm.plugin.webview.model.ak gdd = this.IMs.gdd();
        gdd.iAh = stringExtra5;
        gdd.scene = aXI(stringExtra2);
        this.IMs.gdf().aZd(coX());
        if (fZV()) {
            try {
                Bundle bundle3 = new Bundle();
                bundle3.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                fZs().a(29, bundle3, fZu());
            } catch (Exception e3) {
            }
        }
        if (!Util.isNullOrNil(stringExtra3)) {
            try {
                fZs().aZW(stringExtra3);
            } catch (Exception e4) {
                Log.e(getTAG(), "postBinded, fail triggerGetContact, ex = " + e4.getMessage());
            }
        }
        try {
            int intExtra3 = getIntent().getIntExtra("pay_channel", -1);
            if (intExtra3 != -1) {
                Log.i(getTAG(), "hy: found channel in intent. pay channel: %d", Integer.valueOf(intExtra3));
            } else {
                int payChannel = fZs().getPayChannel();
                if (payChannel != -1) {
                    Log.i(getTAG(), "hy: found channel in channel helper. pay channel: %d", Integer.valueOf(payChannel));
                    getIntent().putExtra("pay_channel", payChannel);
                }
            }
        } catch (Exception e5) {
            Log.e(getTAG(), "hy: init pay channel failed");
        }
        this.ILX.clear();
        com.tencent.mm.plugin.webview.d.h jsapi = getJsapi();
        String stringExtra10 = getIntent().getStringExtra("geta8key_username");
        Map<String, Object> f2 = kotlin.a.ae.f(kotlin.s.U("message_id", Long.valueOf(getIntent().getLongExtra("message_id", 0))), kotlin.s.U("message_index", Integer.valueOf(getIntent().getIntExtra("message_index", 0))), kotlin.s.U("scene", Integer.valueOf(aXI(stringExtra10))), kotlin.s.U("pay_channel", Integer.valueOf(getIntent().getIntExtra("pay_channel", 0))), kotlin.s.U("stastic_scene", Integer.valueOf(getIntent().getIntExtra("stastic_scene", 0))), kotlin.s.U("from_scence", Integer.valueOf(getIntent().getIntExtra("from_scence", 0))));
        String stringExtra11 = getIntent().getStringExtra("srcUsername");
        if (!(stringExtra11 == null || kotlin.n.n.aL(stringExtra11))) {
            f2.putAll(kotlin.a.ae.g(kotlin.s.U("srcUsername", getIntent().getStringExtra("srcUsername")), kotlin.s.U("srcDisplayname", getIntent().getStringExtra("srcDisplayname"))));
        } else {
            String str = stringExtra10;
            if (!(str == null || kotlin.n.n.aL(str))) {
                f2.put("srcUsername", stringExtra10);
            }
        }
        if (!Util.isNullOrNil(getIntent().getStringExtra("KTemplateId"))) {
            String stringExtra12 = getIntent().getStringExtra("KTemplateId");
            kotlin.g.b.p.g(stringExtra12, "intent.getStringExtra(Co…UI.WebViewUI.KTemplateId)");
            f2.put("KTemplateId", stringExtra12);
        }
        int intExtra4 = getIntent().getIntExtra("pay_scene", -1);
        if (intExtra4 != -1) {
            Log.i(getTAG(), "get pay scene from extra: %s", Integer.valueOf(intExtra4));
        } else {
            intExtra4 = 3;
            Log.i(getTAG(), "default pay scene to: %s", 3);
        }
        f2.put("pay_scene", Integer.valueOf(intExtra4));
        jsapi.bG(f2);
        List<com.tencent.mm.plugin.webview.d.d.a> list = this.ILX;
        ArrayList arrayList = new ArrayList();
        arrayList.add(getJsapi());
        arrayList.add(this.ILY);
        arrayList.add(this.ILZ);
        arrayList.add(this.IMa);
        arrayList.add(this.IMb);
        arrayList.add(this.IMc);
        arrayList.add(this.IMd);
        arrayList.add(this.IMg);
        arrayList.add(this.IMj);
        arrayList.add(this.IMk);
        arrayList.add(this.IMl);
        arrayList.add(this.IMn);
        arrayList.add(this.IMi);
        arrayList.add(this.IMm);
        arrayList.add(this.IMh);
        if (getIntent().getBooleanExtra("allow_wx_schema_url", false)) {
            arrayList.add(this.IMq);
        }
        arrayList.add(this.IMp);
        list.addAll(arrayList);
        Log.i(getTAG(), "Abe-Debug controllerListeners call, size = %d", Integer.valueOf(this.IKd.size()));
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().ePr();
        }
        if (this.pGj.getIsX5Kernel()) {
            com.tencent.mm.pluginsdk.ui.tools.r.pl(7);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(64, 64, 1, 0, 1, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(64, 0, 1, false);
        }
        try {
            i2 = Util.getInt(fZs().aZV("WebviewDisableDigestVerify"), 0);
        } catch (Exception e6) {
            Log.w(getTAG(), "getting js digest verification config fails, ex = " + e6.getMessage());
            i2 = 0;
        }
        Log.i(getTAG(), "js digest verification config = %d", Integer.valueOf(i2));
        if (i2 == 0) {
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            kotlin.g.b.p.g(sharedPreferences, "context.getSharedPrefere…ntext.MODE_MULTI_PROCESS)");
            if (sharedPreferences.getBoolean("wvsha1", true) && this.IKM.IKU) {
                getJsapi().gaT();
            }
        }
        try {
            fZs().a(coX(), true, (Bundle) null);
        } catch (Exception e7) {
            Log.w(getTAG(), "postBinded, jumpToActivity, ex = " + e7.getMessage());
        }
        this.IKa.bN("onPostBindedEnd", System.currentTimeMillis());
        AppMethodBeat.o(210257);
    }

    public final boolean fZV() {
        AppMethodBeat.i(210261);
        String stringExtra = getIntent().getStringExtra("srcUsername");
        String stringExtra2 = getIntent().getStringExtra("bizofstartfrom");
        String str = stringExtra;
        if ((str == null || kotlin.n.n.aL(str)) || !kotlin.g.b.p.j(stringExtra2, "enterpriseHomeSubBrand")) {
            AppMethodBeat.o(210261);
            return false;
        }
        AppMethodBeat.o(210261);
        return true;
    }

    public final String aXD(String str) {
        String str2;
        Throwable th;
        AppMethodBeat.i(210262);
        if (!TextUtils.isEmpty(str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("webview_binder_id", fZu());
            bundle.putString("rawUrl", str);
            try {
                str2 = Util.nullAsNil(fZs().j(76, bundle).getString("appId"));
                kotlin.g.b.p.g(str2, "Util.nullAsNil(data.getString(\"appId\"))");
                try {
                    Log.i(getTAG(), "stev cachedAppId %s", str2);
                } catch (Throwable th2) {
                    th = th2;
                    Log.w(getTAG(), "get cachedAppId error ", th.getMessage());
                    AppMethodBeat.o(210262);
                    return str2;
                }
            } catch (Throwable th3) {
                th = th3;
                str2 = "";
                Log.w(getTAG(), "get cachedAppId error ", th.getMessage());
                AppMethodBeat.o(210262);
                return str2;
            }
        } else {
            str2 = "";
        }
        AppMethodBeat.o(210262);
        return str2;
    }

    public final void afK(int i2) {
        AppMethodBeat.i(210263);
        if (i2 <= 0 || i2 > 8) {
            i2 = 2;
        }
        com.tencent.f.h.RTc.aV(new af(this, i2));
        AppMethodBeat.o(210263);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class af implements Runnable {
        final /* synthetic */ int IMV;
        final /* synthetic */ i IMu;

        af(i iVar, int i2) {
            this.IMu = iVar;
            this.IMV = i2;
        }

        public final void run() {
            AppMethodBeat.i(210225);
            this.IMu.getJsapi().afL(this.IMV);
            i iVar = this.IMu;
            int i2 = this.IMV;
            Iterator<T> it = iVar.IKd.iterator();
            while (it.hasNext()) {
                it.next().afL(i2);
            }
            AppMethodBeat.o(210225);
        }
    }

    private final void fZX() {
        AppMethodBeat.i(210265);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", 106);
            bundle.putInt("scene_end_listener_hash_code", fZW().fZu());
            fZs().a(5, bundle, fZW().fZu());
            AppMethodBeat.o(210265);
        } catch (Exception e2) {
            Log.e(getTAG(), "addSceneEnd, ex = " + e2.getMessage());
            AppMethodBeat.o(210265);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8FX\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "Lcom/tencent/mm/plugin/webview/ui/tools/widget/MMWebViewStubCallback;", "controller", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "(Ljava/lang/ref/WeakReference;)V", "TAG", "", "binderId", "", "getBinderId", "()I", "binderId$delegate", "Lkotlin/Lazy;", "onSceneEnd", "", "aidl", "Lcom/tencent/mm/plugin/webview/stub/OnSceneEnd_AIDL;", "plugin-webview_release"})
    public static final class p extends com.tencent.mm.plugin.webview.ui.tools.widget.m {
        private final kotlin.f IJW = kotlin.g.ah(new a(this));
        private final String TAG = ("MicroMsg.WebViewController.SceneEndCallbacker:" + fZu());
        private final WeakReference<i> VgG;

        public final int fZu() {
            AppMethodBeat.i(210194);
            int intValue = ((Number) this.IJW.getValue()).intValue();
            AppMethodBeat.o(210194);
            return intValue;
        }

        public p(WeakReference<i> weakReference) {
            kotlin.g.b.p.h(weakReference, "controller");
            AppMethodBeat.i(259812);
            this.VgG = weakReference;
            AppMethodBeat.o(259812);
        }

        @Override // com.tencent.mm.plugin.webview.stub.f, com.tencent.mm.plugin.webview.ui.tools.widget.m
        public final boolean a(com.tencent.mm.plugin.webview.stub.d dVar) {
            AppMethodBeat.i(210195);
            Log.i(this.TAG, "onSceneEnd, instance hashcode = " + hashCode());
            if (dVar != null) {
                int i2 = dVar.getData().getInt("scene_end_listener_hash_code");
                Log.i(this.TAG, "get hash code = %d, self hash code = %d", Integer.valueOf(i2), Integer.valueOf(fZu()));
                Log.i(this.TAG, "edw onSceneEnd, type = " + dVar.getType() + ", errCode = " + dVar.getErrCode() + ", errType = " + dVar.getErrType());
                if (i2 == fZu()) {
                    i iVar = this.VgG.get();
                    if (iVar != null) {
                        switch (dVar.getType()) {
                            case 106:
                                i.a(iVar, 106);
                                iVar.onFinish();
                                break;
                            case com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX:
                                i.a(iVar, (int) com.tencent.mm.plugin.appbrand.game.e.a.e.CTRL_INDEX);
                                iVar.onFinish();
                                break;
                        }
                    }
                } else {
                    Log.e(this.TAG, "hash code not equal");
                    AppMethodBeat.o(210195);
                    return false;
                }
            }
            AppMethodBeat.o(210195);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
            final /* synthetic */ p IMI;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(p pVar) {
                super(0);
                this.IMI = pVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Integer invoke() {
                AppMethodBeat.i(210193);
                Integer valueOf = Integer.valueOf(this.IMI.hashCode());
                AppMethodBeat.o(210193);
                return valueOf;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\u0010\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$oauthDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$WebviewUIDelegate;", "dismissLoadingDialog", "", "doGetA8Key", "url", "", "reason", "", "goBack", "safeDismissDialog", "dialog", "Landroid/app/Dialog;", "showLoadingDialog", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "plugin-webview_release"})
    public static final class z implements ag.c {
        final /* synthetic */ i IMu;
        final /* synthetic */ MMWebView pGm;

        z(i iVar, MMWebView mMWebView) {
            this.IMu = iVar;
            this.pGm = mMWebView;
        }

        @Override // com.tencent.mm.plugin.webview.model.ag.c
        public final void aXL(String str) {
            AppMethodBeat.i(210211);
            kotlin.g.b.p.h(str, "url");
            this.IMu.k(str, true, 9);
            AppMethodBeat.o(210211);
        }

        @Override // com.tencent.mm.plugin.webview.model.ag.c
        public final void goBack() {
            AppMethodBeat.i(210212);
            Iterator<T> it = this.IMu.IKd.iterator();
            while (it.hasNext()) {
                it.next().gac();
            }
            AppMethodBeat.o(210212);
        }

        @Override // com.tencent.mm.plugin.webview.model.ag.c
        public final void e(DialogInterface.OnCancelListener onCancelListener) {
            AppMethodBeat.i(210213);
            kotlin.g.b.p.h(onCancelListener, "cancelListener");
            c(this.IMu.ILT);
            this.IMu.ILT = com.tencent.mm.ui.base.h.a(this.pGm.getActivityContextIfHas(), this.IMu.getContext().getString(R.string.fhx), true, onCancelListener);
            AppMethodBeat.o(210213);
        }

        @Override // com.tencent.mm.plugin.webview.model.ag.c
        public final void cGW() {
            AppMethodBeat.i(210214);
            c(this.IMu.ILT);
            AppMethodBeat.o(210214);
        }

        private static void c(Dialog dialog) {
            AppMethodBeat.i(210215);
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
                dialog.setCancelMessage(null);
                dialog.setDismissMessage(null);
            }
            AppMethodBeat.o(210215);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$oauthOnSceneEndDelegate$1", "Lcom/tencent/mm/plugin/webview/model/OauthAuthorizeLogic$OnSceneEndDelegate;", "mCountMap", "", "", "add", "", "type", "hasAddListeners", "", "remove", "plugin-webview_release"})
    public static final class aa implements ag.a {
        private final Map<Integer, Integer> IMR = new HashMap();
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        aa(i iVar) {
            this.IMu = iVar;
            AppMethodBeat.i(210217);
            AppMethodBeat.o(210217);
        }

        @Override // com.tencent.mm.plugin.webview.model.ag.a
        public final void xr() {
            AppMethodBeat.i(210216);
            i.a(this.IMu, 1373);
            if (this.IMR.containsKey(1373)) {
                Integer num = this.IMR.get(1373);
                if (num == null) {
                    kotlin.g.b.p.hyc();
                }
                this.IMR.put(1373, Integer.valueOf(num.intValue() - 1));
                AppMethodBeat.o(210216);
                return;
            }
            this.IMR.put(1373, 0);
            AppMethodBeat.o(210216);
        }
    }

    private final boolean aXG(String str) {
        AppMethodBeat.i(210266);
        if (Util.isNullOrNil(str)) {
            Log.e(getTAG(), "search contact err: null or nill url");
            AppMethodBeat.o(210266);
            return false;
        }
        fZX();
        Bundle bundle = new Bundle();
        bundle.putString("search_contact_data_url", str);
        bundle.putInt("webview_binder_id", fZW().fZu());
        try {
            fZs().x(106, bundle);
        } catch (Exception e2) {
            Log.w(getTAG(), "startSearchContact, ex = " + e2.getMessage());
        }
        AppMethodBeat.o(210266);
        return true;
    }

    private final boolean aXH(String str) {
        boolean z2;
        boolean z3;
        boolean z4;
        String str2;
        List<String> hMi;
        List<String> hMi2;
        AppMethodBeat.i(210267);
        Log.i(getTAG(), "dealCustomScheme, url = ".concat(String.valueOf(str)));
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            AppMethodBeat.o(210267);
            return false;
        }
        try {
            if (fZs().gw(str)) {
                Log.i(getTAG(), "dealCustomScheme, url is handled by QrCodeURLHelper, url = ".concat(String.valueOf(str)));
                fZs().gt(str, fZu());
                AppMethodBeat.o(210267);
                return true;
            }
        } catch (Exception e2) {
            Log.w(getTAG(), "dealCustomScheme, tryHandleEvents, ex = " + e2.getMessage());
        }
        Uri parse = Uri.parse(str);
        if (parse != null && !kotlin.n.n.J(str, "weixin://", false) && !kotlin.n.n.J(str, "http", false)) {
            if (kotlin.n.n.J(str, com.tencent.smtt.sdk.WebView.SCHEME_TEL, false)) {
                String j2 = kotlin.n.n.j(str, com.tencent.smtt.sdk.WebView.SCHEME_TEL, "", false);
                if (!Util.isNullOrNil(j2)) {
                    try {
                        fZs().gv(j2, fZu());
                    } catch (Exception e3) {
                        Log.w(getTAG(), "showPhoneSpanDialog, ex = %s", e3.getMessage());
                    }
                }
                AppMethodBeat.o(210267);
                return true;
            } else if (kotlin.n.n.J(str, "sms:", false) || kotlin.n.n.J(str, "smsto:", false)) {
                if (this.pGj.getActivityContextIfHas() == null) {
                    Log.e(getTAG(), "sms, viewWV.activityContextIfHas = null");
                    AppMethodBeat.o(210267);
                    return true;
                }
                f.a aVar = com.tencent.mm.plugin.webview.ui.tools.f.Jfx;
                Context activityContextIfHas = this.pGj.getActivityContextIfHas();
                kotlin.g.b.p.g(activityContextIfHas, "viewWV.activityContextIfHas");
                kotlin.g.b.p.h(activityContextIfHas, "context");
                kotlin.g.b.p.h(str, "url");
                kotlin.g.b.p.h(activityContextIfHas, "context");
                kotlin.g.b.p.h(str, "url");
                kotlin.n.i aK = new kotlin.n.k("sms:(\\d*)(\\?body=(.*))?").aK(str);
                String str4 = (aK == null || (hMi2 = aK.hMi()) == null) ? null : (String) kotlin.a.j.L(hMi2, 1);
                String str5 = (aK == null || (hMi = aK.hMi()) == null) ? null : (String) kotlin.a.j.L(hMi, 3);
                String str6 = str4;
                if (str6 == null || str6.length() == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    str2 = activityContextIfHas.getString(R.string.hts);
                } else {
                    String str7 = str4;
                    if (str7 == null || str7.length() == 0) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (!z3) {
                        String str8 = str5;
                        if (str8 == null || str8.length() == 0) {
                            str2 = Util.safeFormatString(activityContextIfHas.getString(R.string.htt), str4);
                        }
                    }
                    String str9 = str4;
                    if (str9 == null || str9.length() == 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z4) {
                        String str10 = str5;
                        if (!(str10 == null || str10.length() == 0)) {
                            str2 = Util.safeFormatString(activityContextIfHas.getString(R.string.htu), str5, str4);
                        }
                    }
                    str2 = "";
                }
                if (!Util.isNullOrNil(str2)) {
                    com.tencent.mm.ac.d.h(new f.a.C1985a(activityContextIfHas, str2, str));
                } else {
                    Log.e(com.tencent.mm.plugin.webview.ui.tools.f.access$getTAG$cp(), "sms, url is illegal, url = %s", str);
                }
                AppMethodBeat.o(210267);
                return true;
            } else if (kotlin.n.n.J(str, com.tencent.smtt.sdk.WebView.SCHEME_MAILTO, false)) {
                Intent intent = new Intent("android.intent.action.SENDTO");
                intent.addFlags(268435456);
                intent.setData(parse);
                try {
                    Context context = getContext();
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    context.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                } catch (Exception e4) {
                    Log.e(getTAG(), "start mailto app failed:[%s]", e4.getMessage());
                }
                AppMethodBeat.o(210267);
                return true;
            } else {
                try {
                    if (this.mHi.gdI().gtB() || !fZs().gdW()) {
                        int intExtra = getIntent().getIntExtra("key_download_restrict", 0);
                        String stringExtra = getIntent().getStringExtra("key_function_id");
                        if (!Util.isNullOrNil(stringExtra)) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(14596, stringExtra, Integer.valueOf(intExtra), 1);
                        }
                        if (intExtra == 1) {
                            Log.e(getTAG(), "not allow launch app by custom scheme : %s", str);
                            AppMethodBeat.o(210267);
                            return true;
                        }
                        long nowSecond = Util.nowSecond() - this.ILW;
                        Log.i(getTAG(), "scheme launch interval ; %d", Long.valueOf(nowSecond));
                        if (nowSecond <= 2) {
                            String currentUrl = getCurrentUrl();
                            try {
                                currentUrl = com.tencent.mm.compatible.util.q.encode(currentUrl, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                                str = com.tencent.mm.compatible.util.q.encode(str, MimeTypeUtil.ContentType.DEFAULT_CHARSET);
                            } catch (Exception e5) {
                                Log.i(getTAG(), "formate url failed");
                            }
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(13983, 4, currentUrl, str);
                        }
                        if (getIntent().getBooleanExtra("show_openapp_dialog", true)) {
                            boolean post = com.tencent.mm.ch.a.post(new u(this, parse));
                            AppMethodBeat.o(210267);
                            return post;
                        }
                        Intent intent2 = new Intent("android.intent.action.VIEW", parse);
                        intent2.addFlags(268435456);
                        if (Util.isIntentAvailable(getContext(), intent2)) {
                            Context context2 = getContext();
                            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            com.tencent.mm.hellhoundlib.a.a.a(context2, bl2.axQ(), "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            context2.startActivity((Intent) bl2.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/webview/core/WebViewController", "dealCustomScheme", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            AppMethodBeat.o(210267);
                            return true;
                        }
                    } else {
                        Log.e(getTAG(), "dealCustomScheme, not allow outer open url");
                        AppMethodBeat.o(210267);
                        return true;
                    }
                } catch (RemoteException e6) {
                    Log.printErrStackTrace(getTAG(), e6, "", new Object[0]);
                }
            }
        }
        AppMethodBeat.o(210267);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(210197);
            String str = "MicroMsg.WebViewController:" + this.IMu.fZu();
            AppMethodBeat.o(210197);
            return str;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/lang/Class;", "Lcom/tencent/mm/plugin/webview/stub/WebViewStubService;", "invoke"})
    static final class aj extends kotlin.g.b.q implements kotlin.g.a.a<Class<WebViewStubService>> {
        public static final aj IMX = new aj();

        static {
            AppMethodBeat.i(210230);
            AppMethodBeat.o(210230);
        }

        aj() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ Class<WebViewStubService> invoke() {
            return WebViewStubService.class;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class x extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(210209);
            Boolean valueOf = Boolean.valueOf(this.IMu.getIntent().getBooleanExtra("KFromLoginHistory", false));
            AppMethodBeat.o(210209);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(210208);
            Boolean valueOf = Boolean.valueOf(this.IMu.getIntent().getBooleanExtra("finishviewifloadfailed", false));
            AppMethodBeat.o(210208);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00060\u0001R\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$VisitInfoReport;", "Lcom/tencent/mm/plugin/webview/core/WebViewController;", "invoke"})
    static final class ak extends kotlin.g.b.q implements kotlin.g.a.a<t> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ak(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ t invoke() {
            AppMethodBeat.i(210231);
            t tVar = new t(this.IMu, this.IMu);
            AppMethodBeat.o(210231);
            return tVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(210210);
            Boolean valueOf = Boolean.valueOf(this.IMu.getIntent().getBooleanExtra("neverBlockLocalRequest", false));
            AppMethodBeat.o(210210);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class u implements Runnable {
        final /* synthetic */ Uri IMQ;
        final /* synthetic */ i IMu;

        u(i iVar, Uri uri) {
            this.IMu = iVar;
            this.IMQ = uri;
        }

        public final void run() {
            AppMethodBeat.i(210206);
            com.tencent.mm.pluginsdk.model.app.h.k(this.IMu.pGj.getActivityContextIfHas(), this.IMQ);
            AppMethodBeat.o(210206);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/ui/tools/MMSslErrorHandler;", "invoke"})
    static final class ai extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.ui.tools.c> {
        final /* synthetic */ MMWebView pGm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(MMWebView mMWebView) {
            super(0);
            this.pGm = mMWebView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.ui.tools.c invoke() {
            AppMethodBeat.i(210229);
            com.tencent.mm.plugin.webview.ui.tools.c cVar = new com.tencent.mm.plugin.webview.ui.tools.c(this.pGm.getActivityContextIfHas(), this.pGm);
            AppMethodBeat.o(210229);
            return cVar;
        }
    }

    public final int bLC() {
        AppMethodBeat.i(210268);
        int aXI = aXI(getIntent().getStringExtra("geta8key_username"));
        AppMethodBeat.o(210268);
        return aXI;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/modeltools/WebViewURLRouteList;", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.modeltools.n> {
        public static final ag IMW = new ag();

        static {
            AppMethodBeat.i(210227);
            AppMethodBeat.o(210227);
        }

        ag() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.modeltools.n invoke() {
            AppMethodBeat.i(210226);
            com.tencent.mm.plugin.webview.modeltools.n nVar = new com.tencent.mm.plugin.webview.modeltools.n();
            AppMethodBeat.o(210226);
            return nVar;
        }
    }

    private boolean aXJ(String str) {
        AppMethodBeat.i(210270);
        kotlin.g.b.p.h(str, "url");
        for (com.tencent.mm.plugin.webview.d.d.a aVar : this.ILX) {
            if (aVar.aXK(str)) {
                Log.i(getTAG(), "url handled, url = ".concat(String.valueOf(str)));
                Log.i(getTAG(), "url handled, ret = " + aVar.aXJ(str) + ", url = " + str);
                AppMethodBeat.o(210270);
                return true;
            }
        }
        AppMethodBeat.o(210270);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$OauthHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
    public static final class l implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210184);
            kotlin.g.b.p.h(str, "url");
            boolean gr = ag.b.gr(str, this.IMu.getIntent().getIntExtra("geta8key_scene", 0));
            AppMethodBeat.o(210184);
            return gr;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210185);
            kotlin.g.b.p.h(str, "url");
            String stringExtra = this.IMu.getIntent().getStringExtra("geta8key_username");
            boolean a2 = ag.b.a(str, stringExtra, this.IMu.aXI(stringExtra), this.IMu.fZs(), this.IMu.ILU, this.IMu.ILV, i.e(this.IMu).fZu(), this.IMu.getContext());
            AppMethodBeat.o(210185);
            return a2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$GoProfileHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GO_PROFILE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class j implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMB = "weixin://profile/";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210180);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210180);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMB);
            AppMethodBeat.o(210180);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210181);
            kotlin.g.b.p.h(str, "url");
            String substring = str.substring(this.IMB.length());
            kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
            if (substring.length() == 0) {
                Log.e(i.a(this.IMu), "handleUrl fail, username is null");
                AppMethodBeat.o(210181);
            } else {
                if (this.IMu.mHi.gdH().pP(2)) {
                    this.IMu.getJsapi().aYf(substring);
                }
                AppMethodBeat.o(210181);
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$CriticalUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CRITICAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class e implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        private final String IMx = "weixin://critical_update/";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210170);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210170);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMx);
            AppMethodBeat.o(210170);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210171);
            kotlin.g.b.p.h(str, "url");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 25, 1, true);
            i.b(this.IMu, 1);
            AppMethodBeat.o(210171);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$ManualUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "MANUAL_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class k implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMC = "weixin://manual_update/";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210182);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210182);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMC);
            AppMethodBeat.o(210182);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210183);
            kotlin.g.b.p.h(str, "url");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 26, 1, true);
            i.b(this.IMu, 3);
            AppMethodBeat.o(210183);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$RecommendUpdateHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "RECOMMEND_UPDATE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class n implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMF = "weixin://recommend_update/";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        n(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210189);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210189);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMF);
            AppMethodBeat.o(210189);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210190);
            kotlin.g.b.p.h(str, "url");
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(405, 24, 1, true);
            i.b(this.IMu, 2);
            AppMethodBeat.o(210190);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$ActivityJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "plugin-webview_release"})
    public static final class a implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        a(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210164);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210164);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, "weixin://jump/");
            AppMethodBeat.o(210164);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210165);
            kotlin.g.b.p.h(str, "url");
            if (!this.IMu.mHi.gdI().gtC()) {
                Log.e(i.a(this.IMu), "ActivityJumpHandler not allow, no inner url generalcontrol, url = %s", str);
                AppMethodBeat.o(210165);
            } else {
                try {
                    this.IMu.fZs().cP(str, this.IMu.mHi.gdH().pP(7));
                } catch (Exception e2) {
                    Log.w(i.a(this.IMu), "ActivityJumpHandler, ex = " + e2.getMessage());
                }
                AppMethodBeat.o(210165);
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "VIEW_IMAGE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class s implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMJ = "weixin://viewimage/";
        final /* synthetic */ i IMu;
        final /* synthetic */ MMWebView pGm;

        s(i iVar, MMWebView mMWebView) {
            this.IMu = iVar;
            this.pGm = mMWebView;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210200);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210200);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMJ);
            AppMethodBeat.o(210200);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210201);
            kotlin.g.b.p.h(str, "url");
            try {
                if (!this.IMu.fZs().isSDCardAvailable()) {
                    this.IMu.fZs().a(2, (Bundle) null, this.IMu.fZu());
                    AppMethodBeat.o(210201);
                    return true;
                }
                i iVar = this.IMu;
                String substring = str.substring(this.IMJ.length());
                kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
                iVar.IMe = substring;
                Log.i(i.a(this.IMu), "viewimage currentUrl :" + this.IMu.IMe);
                com.tencent.mm.pluginsdk.ui.tools.z.a(this.pGm, this.IMu.IMi.IMA, "'<head>' + document.getElementsByTagName('head')[0].innerHTML + '</head><body>' + document.getElementsByTagName('body')[0].innerHTML + '</body>'", this.IMu.IMf);
                AppMethodBeat.o(210201);
                return true;
            } catch (Exception e2) {
                Log.e(i.a(this.IMu), "edw handleUrl, ex = " + e2.getMessage());
                AppMethodBeat.o(210201);
                return false;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$GetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    /* renamed from: com.tencent.mm.plugin.webview.core.i$i  reason: collision with other inner class name */
    public static final class C1946i implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMA = "weixin://gethtml/";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        C1946i(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210178);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210178);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMA);
            AppMethodBeat.o(210178);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210179);
            kotlin.g.b.p.h(str, "url");
            if (!Util.isNullOrNil(str)) {
                String substring = str.substring(this.IMA.length());
                kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
                Log.i(i.a(this.IMu), "[oneliang]get html content :".concat(String.valueOf(substring)));
                i iVar = this.IMu;
                kotlin.g.b.p.h(substring, "html");
                Iterator<T> it = iVar.IKd.iterator();
                while (it.hasNext()) {
                    it.next().aXO(substring);
                }
            }
            AppMethodBeat.o(210179);
            return false;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$ViewImageGetHtmlHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "GET_HTML_HANDLER", "", "getGET_HTML_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class r implements com.tencent.mm.plugin.webview.d.d.a {
        final String IMA = "weixin://private/gethtml/";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        r(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210198);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210198);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMA);
            AppMethodBeat.o(210198);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210199);
            kotlin.g.b.p.h(str, "url");
            String substring = str.substring(this.IMA.length());
            kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
            try {
                String decode = URLDecoder.decode(substring);
                Bundle bundle = new Bundle();
                bundle.putString("nowUrl", this.IMu.IMe);
                bundle.putString("tweetid", Util.nullAsNil(this.IMu.getIntent().getStringExtra("tweetid")));
                bundle.putString("htmlData", decode);
                bundle.putInt("type", this.IMu.getIntent().getIntExtra("type", 0));
                this.IMu.fZs().a(3, bundle, this.IMu.fZu());
                AppMethodBeat.o(210199);
                return true;
            } catch (Exception e2) {
                Log.e(i.a(this.IMu), "edw ViewImageGetHtmlHandler handleUrl, ex = " + e2.getMessage());
                AppMethodBeat.o(210199);
                return false;
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$ReaderShareHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "READER_SHARE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "share", "", "plugin-webview_release"})
    public static final class m implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMD = "weixin://readershare/";
        final /* synthetic */ i IMu;
        final /* synthetic */ MMWebView pGm;

        m(i iVar, MMWebView mMWebView) {
            this.IMu = iVar;
            this.pGm = mMWebView;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210187);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210187);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMD);
            AppMethodBeat.o(210187);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210188);
            kotlin.g.b.p.h(str, "url");
            String string = this.IMu.getContext().getString(R.string.fu2);
            kotlin.g.b.p.g(string, "context.getString(R.string.readerapp_share_weibo)");
            com.tencent.mm.ui.base.h.a(this.pGm.getActivityContextIfHas(), "", new String[]{string}, "", new a(this));
            AppMethodBeat.o(210188);
            return true;
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "whichButton", "", "onClick"})
        static final class a implements h.d {
            final /* synthetic */ m IME;

            a(m mVar) {
                this.IME = mVar;
            }

            @Override // com.tencent.mm.ui.base.h.d
            public final void oj(int i2) {
                AppMethodBeat.i(210186);
                if (i2 == 0) {
                    m mVar = this.IME;
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("shortUrl", mVar.IMu.getIntent().getStringExtra("shortUrl"));
                        bundle.putInt("type", mVar.IMu.getIntent().getIntExtra("type", 0));
                        mVar.IMu.fZs().a(4, bundle, mVar.IMu.fZu());
                        AppMethodBeat.o(210186);
                        return;
                    } catch (Exception e2) {
                        Log.e(i.a(mVar.IMu), "share fail, ex = " + e2.getMessage());
                    }
                }
                AppMethodBeat.o(210186);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$FeedbackJumpHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FEEDBACK_JUMP_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class g implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        private final String IMy = "weixin://feedback/";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210174);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210174);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMy);
            AppMethodBeat.o(210174);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210175);
            kotlin.g.b.p.h(str, "url");
            Bundle bundle = new Bundle();
            bundle.putInt("MMActivity.OverrideEnterAnimation", 0);
            bundle.putInt("MMActivity.OverrideExitAnimation", R.anim.f6do);
            try {
                this.IMu.fZs().a(7, bundle, this.IMu.fZu());
            } catch (Exception e2) {
                Log.w(i.a(this.IMu), "FeedbackJumpHandler, ex = " + e2.getMessage());
            }
            AppMethodBeat.o(210175);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003XD¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$AddFriendHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "ADD_FRIEND_HANDLER", "", "getADD_FRIEND_HANDLER", "()Ljava/lang/String;", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class b implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        private final String IMv = "weixin://addfriend/";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        b(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210166);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210166);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMv);
            AppMethodBeat.o(210166);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210167);
            kotlin.g.b.p.h(str, "url");
            if (!this.IMu.mHi.gdH().pP(5)) {
                Log.e(i.a(this.IMu), "AddFriendHandler, permission fail");
                AppMethodBeat.o(210167);
                return true;
            }
            String substring = str.substring(this.IMv.length());
            kotlin.g.b.p.g(substring, "(this as java.lang.String).substring(startIndex)");
            if (Util.isNullOrNil(substring)) {
                AppMethodBeat.o(210167);
                return false;
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("from_webview", true);
            bundle.putString("userName", substring);
            try {
                this.IMu.fZs().a(8, bundle, this.IMu.fZu());
            } catch (Exception e2) {
                Log.w(i.a(this.IMu), "AddFriendHandler, ex = " + e2.getMessage());
            }
            AppMethodBeat.o(210167);
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$SDKOpenWebViewResultHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "COPY_LINK_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class o implements com.tencent.mm.plugin.webview.d.d.a {
        private final String IMG = "weixin://openapi/openwebview/result?";
        final /* synthetic */ i IMu;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        o(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210191);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210191);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMG);
            AppMethodBeat.o(210191);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210192);
            kotlin.g.b.p.h(str, "url");
            OpenWebview.Resp resp = new OpenWebview.Resp();
            Uri parse = Uri.parse(str);
            kotlin.g.b.p.g(parse, ShareConstants.MEDIA_URI);
            resp.result = parse.getQuery();
            resp.errCode = Util.getInt(parse.getQueryParameter("errCode"), 0);
            resp.errStr = parse.getQueryParameter("errMsg");
            resp.transaction = this.IMu.getIntent().getStringExtra("transaction_for_openapi_openwebview");
            String queryParameter = parse.getQueryParameter("appid");
            if (Util.isNullOrNil(queryParameter)) {
                Log.e(i.a(this.IMu), "SDKOpenWebViewResultHandler handleUrl, appId is null");
                AppMethodBeat.o(210192);
            } else {
                Bundle bundle = new Bundle();
                resp.toBundle(bundle);
                com.tencent.mm.pluginsdk.model.app.q.bo(bundle);
                MMessageActV2.Args args = new MMessageActV2.Args();
                try {
                    args.targetPkgName = this.IMu.fZs().aZT(queryParameter);
                    args.bundle = bundle;
                    Log.d(i.a(this.IMu), "SDKOpenWebViewResultHandler, handleUrl, sendResp:%s", args);
                    MMessageActV2.send(this.IMu.getContext(), args);
                    this.IMu.onFinish();
                    AppMethodBeat.o(210192);
                } catch (Exception e2) {
                    Log.printErrStackTrace(i.a(this.IMu), e2, "", new Object[0]);
                    AppMethodBeat.o(210192);
                }
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$CloseHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "CLOSE_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class c implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        private final String IMw = "weixin://webview/close/";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        c(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210168);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210168);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMw);
            AppMethodBeat.o(210168);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210169);
            kotlin.g.b.p.h(str, "url");
            if (!this.IMu.mHi.gdH().pP(17)) {
                Log.e(i.a(this.IMu), "close window permission fail");
                AppMethodBeat.o(210169);
            } else {
                this.IMu.onFinish();
                AppMethodBeat.o(210169);
            }
            return true;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$DeepLinkHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "canHandleUrl", "", "url", "", "handleUrl", "urlOrig", "plugin-webview_release"})
    public static final class f implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        final /* synthetic */ MMWebView pGm;

        f(i iVar, MMWebView mMWebView) {
            this.IMu = iVar;
            this.pGm = mMWebView;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210172);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210172);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, "weixin://");
            AppMethodBeat.o(210172);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            boolean z;
            AppMethodBeat.i(210173);
            kotlin.g.b.p.h(str, "urlOrig");
            int aXI = this.IMu.aXI(Util.nullAsNil(i.i(this.IMu)));
            String bcY = com.tencent.mm.pluginsdk.g.bcY(str);
            if (com.tencent.mm.pluginsdk.g.bM(bcY, this.IMu.IMo)) {
                try {
                    if (kotlin.g.b.p.j("weixin://dl/shopping", bcY)) {
                        String gea = this.IMu.fZs().gea();
                        kotlin.g.b.p.g(gea, "invoker.getJDUrl()");
                        if (!Util.isNullOrNil(gea)) {
                            BaseWebViewController.a(this.IMu, gea, (Map) null, 6);
                        }
                    } else if (kotlin.g.b.p.j("weixin://dl/faq", bcY)) {
                        String string = MMApplicationContext.getContext().getString(R.string.gv4, Integer.valueOf(this.IMu.fZs().gec()), Integer.valueOf(this.IMu.fZs().ged()));
                        kotlin.g.b.p.g(string, "MMApplicationContext.get…otice_url, uin, newCount)");
                        BaseWebViewController.a(this.IMu, string, (Map) null, 6);
                    } else if (kotlin.g.b.p.j("weixin://dl/posts", bcY)) {
                        this.IMu.fZs().gee();
                    } else if (kotlin.g.b.p.j("weixin://dl/moments", bcY)) {
                        this.IMu.fZs().gef();
                    } else {
                        kotlin.g.b.p.g(bcY, "url");
                        if (kotlin.n.n.J(bcY, "weixin://dl/feedback", false)) {
                            kotlin.g.b.p.g(this.IMu.fZs().baa(bcY), "invoker.getFeedbackUrl(url)");
                        } else if (kotlin.g.b.p.j("weixin://dl/scan", bcY)) {
                            com.tencent.mm.br.c.c(this.IMu.getContext(), "scanner", ".ui.BaseScanUI", new Intent());
                        } else {
                            com.tencent.mm.pluginsdk.g.ce(this.pGm.getActivityContextIfHas(), bcY);
                        }
                    }
                    ArrayList arrayList = new ArrayList();
                    kotlin.g.b.p.g(bcY, "url");
                    arrayList.add(bcY);
                    arrayList.add("1");
                    arrayList.add(String.valueOf(aXI));
                    String nullAsNil = Util.nullAsNil(i.i(this.IMu));
                    kotlin.g.b.p.g(nullAsNil, "Util.nullAsNil(sentUsername)");
                    arrayList.add(nullAsNil);
                    String nullAsNil2 = Util.nullAsNil(this.IMu.coX());
                    kotlin.g.b.p.g(nullAsNil2, "Util.nullAsNil(rawUrl)");
                    arrayList.add(nullAsNil2);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    com.tencent.mm.plugin.report.service.h.r(11405, arrayList);
                    z = true;
                } catch (Exception e2) {
                    Log.e(i.a(this.IMu), "kv report fail, ex = %s", e2.getMessage());
                    z = true;
                }
            } else {
                z = false;
            }
            AppMethodBeat.o(210173);
            return z;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003XD¢\u0006\u0002\n\u0000¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/WebViewController$FreeWifiConnectHandler$1", "Lcom/tencent/mm/plugin/webview/jsapi/url/IUrlHandler;", "FREE_WIFI_CONNECT_HANDLER", "", "canHandleUrl", "", "url", "handleUrl", "plugin-webview_release"})
    public static final class h implements com.tencent.mm.plugin.webview.d.d.a {
        final /* synthetic */ i IMu;
        private final String IMz = "weixin://connectToFreeWifi/";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(i iVar) {
            this.IMu = iVar;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXK(String str) {
            AppMethodBeat.i(210176);
            kotlin.g.b.p.h(str, "url");
            if (Util.isNullOrNil(str)) {
                AppMethodBeat.o(210176);
                return false;
            }
            boolean C = com.tencent.mm.pluginsdk.ui.tools.z.C(str, this.IMz);
            AppMethodBeat.o(210176);
            return C;
        }

        @Override // com.tencent.mm.plugin.webview.d.d.a
        public final boolean aXJ(String str) {
            AppMethodBeat.i(210177);
            kotlin.g.b.p.h(str, "url");
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("apKey");
            Log.i(i.a(this.IMu), "apKey value = %s", queryParameter);
            String queryParameter2 = parse.getQueryParameter("ticket");
            if (!Util.isNullOrNil(queryParameter)) {
                Intent intent = new Intent();
                intent.putExtra("free_wifi_schema_uri", parse.toString());
                intent.putExtra("free_wifi_ap_key", queryParameter);
                intent.putExtra("free_wifi_source", 5);
                if (!Util.isNullOrNil(queryParameter2)) {
                    intent.putExtra("free_wifi_schema_ticket", queryParameter2);
                }
                intent.addFlags(67108864);
                com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "freewifi", ".ui.FreeWifiEntryUI", intent);
            }
            AppMethodBeat.o(210177);
            return true;
        }
    }

    public final com.tencent.luggage.xweb_ext.extendplugin.b.c getWebViewPluginClientProxy() {
        AppMethodBeat.i(210272);
        if (this.IMr == null) {
            fZA();
        }
        com.tencent.luggage.xweb_ext.extendplugin.b.c cVar = this.IMr;
        AppMethodBeat.o(210272);
        return cVar;
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void fZA() {
        AppMethodBeat.i(210273);
        if (this.IMr != null) {
            AppMethodBeat.o(210273);
            return;
        }
        Log.i(getTAG(), "WebView-Trace setWebViewPluginClient");
        this.IMr = com.tencent.luggage.xweb_ext.extendplugin.d.a(this.pGj, com.tencent.luggage.xweb_ext.extendplugin.b.b.QL(), com.tencent.mm.plugin.webview.ui.tools.video.samelayer.g.gie(), null);
        AppMethodBeat.o(210273);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void fZH() {
        AppMethodBeat.i(210274);
        Log.d(getTAG(), "setGetA8KeyParams");
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_req");
        byte[] byteArrayExtra2 = getIntent().getByteArrayExtra("key_scan_qr_code_get_a8key_resp");
        if (!(byteArrayExtra == null || byteArrayExtra2 == null)) {
            Log.i(getTAG(), "set outer get A8key result");
            fZr().k(byteArrayExtra, byteArrayExtra2);
        }
        String stringExtra = getIntent().getStringExtra("geta8key_username");
        String stringExtra2 = getIntent().getStringExtra("msgUsername");
        String stringExtra3 = getIntent().getStringExtra("serverMsgID");
        fZr().aZC(stringExtra2);
        fZr().aZD(stringExtra3);
        fZr().setUsername(stringExtra);
        fZr().setScene(aXI(stringExtra));
        fZr().setAppId(getIntent().getStringExtra("geta8key_open_webview_appid"));
        MMWebView mMWebView = this.pGj;
        if ((mMWebView != null ? Boolean.valueOf(mMWebView.getIsX5Kernel()) : null).booleanValue()) {
            fZr().setFlag(1);
        } else {
            fZr().setFlag(0);
        }
        fZr().av(getIntent().getByteArrayExtra("geta8key_cookie"));
        fZr().age(getIntent().getIntExtra("key_wallet_region", 0));
        fZr().aZB(getIntent().getStringExtra("key_function_id"));
        int intExtra = getIntent().getIntExtra("geta8key_session_id", 0);
        if (intExtra > 0) {
            fZr().DU(intExtra);
        }
        AppMethodBeat.o(210274);
    }

    public final void fZZ() {
        AppMethodBeat.i(210276);
        boolean a2 = com.tencent.mm.plugin.webview.modeltools.k.a(getJsapi(), this.pGj);
        com.tencent.mm.plugin.webview.ui.tools.video.samelayer.h hVar = this.ILF;
        if (hVar != null) {
            hVar.onDestroy();
        }
        com.tencent.mm.plugin.webview.ui.tools.j jVar = this.ILD;
        if (jVar != null) {
            jVar.onDestroy();
        }
        onDestroy();
        this.pGj.removeJavascriptInterface("MicroMsg");
        this.pGj.removeJavascriptInterface("JsApi");
        this.pGj.removeJavascriptInterface("__wx");
        this.pGj.removeJavascriptInterface("CustomFullscreenApi");
        this.pGj.removeJavascriptInterface("__wxtag");
        try {
            this.pGj.setWebChromeClient(null);
            this.pGj.setWebViewClient(null);
            this.pGj.setOnTouchListener(null);
            this.pGj.setOnLongClickListener(null);
            this.pGj.setVisibility(8);
            this.pGj.removeAllViews();
            this.pGj.clearView();
            if (!a2) {
                this.pGj.destroy();
                AppMethodBeat.o(210276);
                return;
            }
        } catch (Exception e2) {
            Log.e(getTAG(), "releaseWebView, ex = %s", e2.getMessage());
        }
        AppMethodBeat.o(210276);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/WebViewController$Companion;", "", "()V", "WEB_TAG", "", "plugin-webview_release"})
    public static final class d {
        private d() {
        }

        public /* synthetic */ d(byte b2) {
            this();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebViewController$SceneEndCallbacker;", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<p> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ p invoke() {
            AppMethodBeat.i(210228);
            p pVar = new p(new WeakReference(this.IMu));
            AppMethodBeat.o(210228);
            return pVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Ljava/util/HashSet;", "", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<HashSet<String>> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ HashSet<String> invoke() {
            String str;
            AppMethodBeat.i(210207);
            HashSet<String> hashSet = new HashSet();
            hashSet.add("file:///android_asset/");
            String aKC = com.tencent.mm.loader.j.b.aKC();
            if (aKC != null) {
                str = kotlin.n.n.j(aKC, "/data/user/0", "/data/data", false);
            } else {
                str = null;
            }
            hashSet.add("file://" + new com.tencent.mm.vfs.o(com.tencent.mm.plugin.websearch.api.ai.afw(0)).getAbsolutePath());
            hashSet.add("file://" + new com.tencent.mm.vfs.o(str, "wenote/res").getAbsolutePath());
            hashSet.add("file://" + new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKJ(), "wenote/res").getAbsolutePath());
            hashSet.add("file://" + com.tencent.mm.plugin.websearch.api.ai.afw(3));
            com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str, "emoji/res");
            hashSet.add("file://" + oVar.getAbsolutePath());
            com.tencent.mm.vfs.o oVar2 = new com.tencent.mm.vfs.o(com.tencent.mm.loader.j.b.aKJ(), "emoji/res");
            hashSet.add("file://" + oVar2.getAbsolutePath());
            Log.i(i.a(this.IMu), "add webview UI FILE URL WHITE LIST data: %s sdcard:%s", oVar.getAbsolutePath(), oVar2.getAbsolutePath());
            hashSet.add("file://" + com.tencent.mm.plugin.websearch.api.ai.afv(4));
            hashSet.add("file://" + com.tencent.mm.plugin.websearch.api.ai.afv(8));
            for (String str2 : hashSet) {
                Log.i(i.a(this.IMu), "albie: WebViewUI white list path : ".concat(String.valueOf(str2)));
            }
            AppMethodBeat.o(210207);
            return hashSet;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ i IMu;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(i iVar) {
            super(0);
            this.IMu = iVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(210218);
            Iterator<T> it = this.IMu.IKd.iterator();
            while (it.hasNext()) {
                it.next().b(this.IMu.IKa);
            }
            com.tencent.mm.plugin.webview.i.b.a(this.IMu.IKa, this.IMu.pGj);
            com.tencent.mm.plugin.webview.i.b.b(this.IMu.IKa, this.IMu.pGj);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(210218);
            return xVar;
        }
    }

    public final String getTitle() {
        AppMethodBeat.i(210236);
        String title = this.pGj.getTitle();
        if (title == null) {
            title = getIntent().getStringExtra("title");
        }
        if (title == null) {
            title = getIntent().getStringExtra("webpageTitle");
        }
        if (title == null) {
            title = "";
        }
        AppMethodBeat.o(210236);
        return title;
    }

    private final String fZR() {
        AppMethodBeat.i(210237);
        if (!afI(this.IKk)) {
            AppMethodBeat.o(210237);
            return "";
        }
        String stringExtra = getIntent().getStringExtra("KPublisherId");
        AppMethodBeat.o(210237);
        return stringExtra;
    }

    @Override // com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void a(WebView webView, com.tencent.xweb.r rVar, SslError sslError) {
        String str;
        String url;
        String str2;
        AppMethodBeat.i(210242);
        if (!afI(this.IKk)) {
            Log.i(getTAG(), "onReceivedSslError, intent not ready");
            AppMethodBeat.o(210242);
            return;
        }
        com.tencent.xweb.util.h.Eq(true);
        if (webView != null) {
            str = webView.getUrl();
        } else {
            str = null;
        }
        if (str == null) {
            url = this.IJM;
        } else {
            url = webView.getUrl();
        }
        if (url != null) {
            com.tencent.mm.kernel.c.a af2 = com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.brandservice.a.b.class);
            kotlin.g.b.p.g(af2, "MMKernel.service(IBrandService::class.java)");
            String clf = ((com.tencent.mm.plugin.brandservice.a.b) af2).clf();
            kotlin.g.b.p.g(clf, "MMKernel.service(IBrandS…::class.java).hardCodeUrl");
            if (kotlin.n.n.J(url, clf, false)) {
                str2 = coX();
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 1, 1, false);
                com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 30, 1, false);
                com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 1);
                com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 30);
                com.tencent.mm.plugin.topstory.a.i.g(fZR(), coX(), 30, this.IMs.gdd().enterTime);
                fZT().a(str2, rVar, sslError);
                super.a(webView, rVar, sslError);
                AppMethodBeat.o(210242);
            }
        }
        str2 = url;
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 1, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 30, 1, false);
        com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 1);
        com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 30);
        com.tencent.mm.plugin.topstory.a.i.g(fZR(), coX(), 30, this.IMs.gdd().enterTime);
        fZT().a(str2, rVar, sslError);
        super.a(webView, rVar, sslError);
        AppMethodBeat.o(210242);
    }

    @Override // com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void a(WebView webView, int i2, String str, String str2) {
        AppMethodBeat.i(210243);
        if (!afI(this.IKk)) {
            Log.i(getTAG(), "onReceivedError, intent not ready");
            AppMethodBeat.o(210243);
            return;
        }
        String domainString = WeChatHosts.domainString(R.string.e20);
        ac acVar = ac.IMS;
        ad adVar = new ad(this);
        com.tencent.xweb.util.h.Eq(false);
        boolean isConnected = NetStatusUtil.isConnected(getContext());
        Log.e(getTAG(), "edw onReceivedError, failingUrl = %s, errorCode = %d, desc = %s, isNetworkConnected = %b", str2, Integer.valueOf(i2), str, Boolean.valueOf(isConnected));
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, 1, 1, false);
        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(155, (long) com.tencent.mm.plugin.webview.i.a.agk(i2), 1, false);
        com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), 1);
        com.tencent.mm.plugin.topstory.a.i.fQ(fZR(), com.tencent.mm.plugin.webview.i.a.agk(i2));
        com.tencent.mm.plugin.topstory.a.i.g(fZR(), coX(), com.tencent.mm.plugin.webview.i.a.agk(i2), this.IMs.gdd().enterTime);
        super.a(webView, i2, str, str2);
        com.tencent.mm.plugin.webview.ui.tools.l.Jhd.agL(i2);
        this.IMs.gdl().errCode = i2;
        com.tencent.mm.plugin.webview.ui.tools.n nVar = com.tencent.mm.plugin.webview.ui.tools.n.JhS;
        com.tencent.mm.plugin.webview.ui.tools.n.setErrCode(i2);
        if (((Boolean) this.ILJ.getValue()).booleanValue()) {
            onFinish();
        }
        try {
            if (kotlin.g.b.p.j(new URL(str2).getHost(), domainString)) {
                com.tencent.f.h.RTc.b(new ae(str2, i2, adVar, domainString), "WebViewUI.CheckDNS");
            }
        } catch (MalformedURLException e2) {
            Log.printErrStackTrace(getTAG(), e2, "check mp url", new Object[0]);
        }
        super.a(webView, i2, str, str2);
        AppMethodBeat.o(210243);
    }

    @Override // com.tencent.xweb.ac, com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void b(WebView webView, String str, boolean z2) {
        AppMethodBeat.i(210246);
        kotlin.g.b.p.h(webView, "view");
        kotlin.g.b.p.h(str, "url");
        this.IJM = str;
        super.b(webView, str, z2);
        AppMethodBeat.o(210246);
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public void cpd() {
        AppMethodBeat.i(210258);
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            if (it.next().e(coX(), getIntent())) {
                AppMethodBeat.o(210258);
                return;
            }
        }
        if (aXJ(coX())) {
            AppMethodBeat.o(210258);
        } else if (cpe()) {
            BaseWebViewController.a((BaseWebViewController) this, coX(), false, 0, 6);
            AppMethodBeat.o(210258);
        } else {
            Log.i(getTAG(), "terry onStartLoad:" + coX());
            String fZx = fZx();
            String str = fZx;
            if (!(str == null || kotlin.n.n.aL(str))) {
                Log.i(getTAG(), fZx);
                if (getIntent().getBooleanExtra("QRDataFlag", true)) {
                    try {
                        fZx = fZs().aZR(fZx);
                    } catch (Exception e2) {
                        Log.w(getTAG(), "postBinded, formatQRString, ex = " + e2.getMessage());
                    }
                }
                com.tencent.xweb.z settings = this.pGj.getSettings();
                kotlin.g.b.p.g(settings, "viewWV.settings");
                settings.setUseWideViewPort(false);
                com.tencent.xweb.z settings2 = this.pGj.getSettings();
                kotlin.g.b.p.g(settings2, "viewWV.settings");
                settings2.setLoadWithOverviewMode(false);
                com.tencent.xweb.z settings3 = this.pGj.getSettings();
                kotlin.g.b.p.g(settings3, "viewWV.settings");
                settings3.setJavaScriptEnabled(false);
                yS(true);
                this.pGj.loadDataWithBaseURL(null, fZx, "text/html", ProtocolPackage.ServerEncoding, null);
                Log.i(getTAG(), "loadDataWithBaseUrl, data = ".concat(String.valueOf(fZx)));
                AppMethodBeat.o(210258);
            } else if (aXC(coX())) {
                Log.f(getTAG(), "postBinded 2, canLoadUrl fail, url = " + coX());
                AppMethodBeat.o(210258);
            } else {
                if (this.IKM.IKW) {
                    this.mHi.a(coX(), null, null);
                }
                Iterator<T> it2 = this.ICu.iterator();
                while (it2.hasNext()) {
                    if (it2.next().aXQ(coX())) {
                        AppMethodBeat.o(210258);
                        return;
                    }
                }
                if (this.pGj.gZa()) {
                    AppMethodBeat.o(210258);
                    return;
                }
                yS(false);
                BaseWebViewController.a(this, coX(), (Map) null, 6);
                AppMethodBeat.o(210258);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public boolean cpe() {
        boolean z2;
        AppMethodBeat.i(210259);
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            if (!it.next().aXR(coX())) {
                AppMethodBeat.o(210259);
                return false;
            }
        }
        String stringExtra = getIntent().getStringExtra("data");
        if (stringExtra == null || kotlin.n.n.aL(stringExtra)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || this.IKM.IKW) {
            AppMethodBeat.o(210259);
            return false;
        }
        AppMethodBeat.o(210259);
        return true;
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void loadUrl(String str, Map<String, String> map, boolean z2) {
        AppMethodBeat.i(210260);
        kotlin.g.b.p.h(str, "url");
        com.tencent.mm.plugin.webview.model.a.a(this.pGj, str);
        super.loadUrl(str, map, z2);
        AppMethodBeat.o(210260);
    }

    public final int aXI(String str) {
        boolean z2;
        AppMethodBeat.i(210269);
        if (this.IKM.IKX != 0) {
            int i2 = this.IKM.IKX;
            AppMethodBeat.o(210269);
            return i2;
        }
        int intExtra = getIntent().getIntExtra("geta8key_scene", 0);
        if (intExtra == 0) {
            String str2 = str;
            if (str2 == null || str2.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                try {
                    if (!afI(this.IKj)) {
                        intExtra = 1;
                    } else if (fZs().JE(str)) {
                        intExtra = 8;
                    } else if (fZs().IT(str)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("enterprise_biz_username", str);
                        try {
                            Bundle j2 = fZs().j(102, bundle);
                            if (j2 == null || j2.getBoolean("is_enterprise_username")) {
                            }
                        } catch (RemoteException e2) {
                            Log.e(getTAG(), "invoke the check enterprise failed");
                        }
                        intExtra = 7;
                    } else {
                        intExtra = 1;
                    }
                } catch (Exception e3) {
                    Log.e(getTAG(), "getScene fail, ex = " + e3.getMessage());
                    intExtra = 1;
                }
            } else {
                intExtra = 0;
            }
        }
        Log.i(getTAG(), "KGetA8KeyScene = %s", Integer.valueOf(intExtra));
        AppMethodBeat.o(210269);
        return intExtra;
    }

    @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController
    public final void onDestroy() {
        AppMethodBeat.i(210271);
        if (afI(this.IKk)) {
            fZS().r("", Util.nowSecond(), 0);
        }
        fZT().detach();
        if (fZV()) {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("srcUsername", getIntent().getStringExtra("srcUsername"));
                fZs().a(30, bundle, fZu());
            } catch (Exception e2) {
            }
        }
        try {
            fZs().agy(fZW().fZu());
        } catch (Exception e3) {
            Log.i(getTAG(), "onDestroy remove callbacker ex " + e3.getMessage());
        }
        super.onDestroy();
        AppMethodBeat.o(210271);
    }

    public final boolean fZY() {
        AppMethodBeat.i(210275);
        if (!this.IJT) {
            AppMethodBeat.o(210275);
            return false;
        }
        fZZ();
        AppMethodBeat.o(210275);
        return true;
    }

    public static final /* synthetic */ void a(i iVar, int i2) {
        AppMethodBeat.i(210282);
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("scene_end_type", i2);
            bundle.putInt("scene_end_listener_hash_code", iVar.fZW().fZu());
            iVar.fZs().a(6, bundle, iVar.fZW().fZu());
            AppMethodBeat.o(210282);
        } catch (Exception e2) {
            Log.e(iVar.getTAG(), "removeSceneEnd, ex = " + e2.getMessage());
            AppMethodBeat.o(210282);
        }
    }

    public static final /* synthetic */ void b(i iVar, int i2) {
        AppMethodBeat.i(210284);
        Bundle bundle = new Bundle();
        bundle.putInt("update_type_key", i2);
        try {
            iVar.fZs().a(1, bundle, iVar.fZu());
            AppMethodBeat.o(210284);
        } catch (Exception e2) {
            Log.e(iVar.getTAG(), "doUpdate fail, ex = " + e2.getMessage());
            AppMethodBeat.o(210284);
        }
    }

    public static final /* synthetic */ String i(i iVar) {
        AppMethodBeat.i(210285);
        String stringExtra = iVar.getIntent().getStringExtra("sentUsername");
        if (stringExtra == null) {
            stringExtra = "";
        }
        AppMethodBeat.o(210285);
        return stringExtra;
    }
}
