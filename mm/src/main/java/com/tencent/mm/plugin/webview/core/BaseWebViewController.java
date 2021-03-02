package com.tencent.mm.plugin.webview.core;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.data.APMidasPluginInfo;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.webview.core.e;
import com.tencent.mm.plugin.webview.core.g;
import com.tencent.mm.plugin.webview.core.k;
import com.tencent.mm.plugin.webview.f.c;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.k.e;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.thumbplayer.core.common.TPAudioFrame;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.ResultKt;
import kotlinx.coroutines.bn;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001d\n\u0000\n\u0002\u0010#\n\u0002\b\u0015\b&\u0018\u0000 \u00032\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:$\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003\u0003B3\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0010\u0010ê\u0001\u001a\u00020r2\u0007\u0010ë\u0001\u001a\u00020ZJ\u0010\u0010ì\u0001\u001a\u00020r2\u0007\u0010ë\u0001\u001a\u00020vJ\u0011\u0010í\u0001\u001a\u00020r2\b\u0010î\u0001\u001a\u00030\u0001J\u001f\u0010ï\u0001\u001a\u00020r2\u0007\u0010ð\u0001\u001a\u00020\u00142\r\u0010ñ\u0001\u001a\b\u0012\u0004\u0012\u00020r0qJ\u0010\u0010ò\u0001\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\nJ\t\u0010ô\u0001\u001a\u00020QH\u0016J\u0012\u0010õ\u0001\u001a\u00020r2\u0007\u0010ö\u0001\u001a\u00020\u0014H\u0004J\u001b\u0010õ\u0001\u001a\u00020r2\u0007\u0010ö\u0001\u001a\u00020\u00142\u0007\u0010ó\u0001\u001a\u00020\nH\u0004J\u0012\u0010÷\u0001\u001a\u00020r2\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J\u0007\u0010ø\u0001\u001a\u00020rJ\t\u0010ù\u0001\u001a\u00020rH\u0016J \u0010ú\u0001\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\t\u0010ó\u0001\u001a\u0004\u0018\u00010\nH\u0002J\u001d\u0010ý\u0001\u001a\u00020Q2\b\u0010û\u0001\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0002J\u001c\u0010ý\u0001\u001a\u00020Q2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J%\u0010\u0002\u001a\u00020r2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\n2\u0007\u0010\u0002\u001a\u00020QH\u0016J\t\u0010\u0002\u001a\u00020QH\u0004J,\u0010\u0002\u001a\u00020r2\u0007\u0010\u0002\u001a\u00020\n2\u0018\b\u0002\u0010ñ\u0001\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020r\u0018\u00010\u0002H\u0004J\u0007\u0010\u0002\u001a\u00020QJ\u0012\u0010\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\nH\u0004J\u0012\u0010\u0002\u001a\u00020\u00142\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J\u0012\u0010\u0002\u001a\u00020\n2\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J\t\u0010\u0002\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0Y2\u0007\u0010ð\u0001\u001a\u00020\u0014H\u0002J\u0012\u0010\u0002\u001a\u00020Q2\u0007\u0010ð\u0001\u001a\u00020\u0014H\u0004J\u0007\u0010\u0002\u001a\u00020rJ\t\u0010\u0002\u001a\u00020rH\u0014J\u0011\u0010\u0002\u001a\u00020r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J.\u0010\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010\u0002\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0014J\u001e\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0004J\u001d\u0010\u0002\u001a\u00030\u00022\b\u0010\u0002\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\nH\u0004J\u0007\u0010\u0002\u001a\u00020QJ\t\u0010\u0002\u001a\u00020QH\u0016J\u0007\u0010\u0001\u001a\u00020QJ'\u0010\u0002\u001a\u00020r2\u0006\u0010I\u001a\u00020\n2\u0016\u0010\u0002\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0002J5\u0010\u0002\u001a\u00020r2\u0006\u0010I\u001a\u00020\n2\u0007\u0010\u0002\u001a\u00020\n2\u0007\u0010\u0002\u001a\u00020\n2\u0007\u0010\u0002\u001a\u00020\n2\t\u0010 \u0002\u001a\u0004\u0018\u00010\nJ7\u0010¦\u0001\u001a\u00020r2\u0007\u0010ó\u0001\u001a\u00020\n2\u0018\b\u0002\u0010¡\u0002\u001a\u0011\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00022\t\b\u0002\u0010¢\u0002\u001a\u00020QH\u0016J\u0012\u0010£\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J\t\u0010¤\u0002\u001a\u00020QH\u0014J\u0014\u0010¥\u0002\u001a\u00020\n2\t\u0010ó\u0001\u001a\u0004\u0018\u00010\nH\u0002J\u001b\u0010¦\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\nH\u0016J\u001b\u0010©\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\nH\u0016J\t\u0010ª\u0002\u001a\u00020rH\u0002J\t\u0010«\u0002\u001a\u00020rH\u0014J(\u0010¬\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\t\u0010¨\u0002\u001a\u0004\u0018\u00010\n2\t\u0010­\u0002\u001a\u0004\u0018\u00010\nH\u0016J\t\u0010®\u0002\u001a\u00020rH\u0016J6\u0010¯\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010°\u0002\u001a\u00020\u00142\u0007\u0010±\u0002\u001a\u00020\u00142\u0007\u0010²\u0002\u001a\u00020\nH\u0016J\t\u0010³\u0002\u001a\u00020rH\u0004J\u0012\u0010´\u0002\u001a\u00020r2\u0007\u0010µ\u0002\u001a\u00020\u0014H\u0004J\t\u0010¶\u0002\u001a\u00020rH\u0004J\t\u0010·\u0002\u001a\u00020rH\u0004J\t\u0010¸\u0002\u001a\u00020rH\u0014J \u0010¹\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\t\u0010ó\u0001\u001a\u0004\u0018\u00010\nH\u0016J \u0010º\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\t\u0010ó\u0001\u001a\u0004\u0018\u00010\nH\u0016J(\u0010»\u0002\u001a\u00020r2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\n2\n\u0010¼\u0002\u001a\u0005\u0018\u00010½\u0002H\u0016J\t\u0010¾\u0002\u001a\u00020rH\u0014J-\u0010¿\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010À\u0002\u001a\u00020\n2\u0007\u0010Á\u0002\u001a\u00020\u0002H\u0016J$\u0010Â\u0002\u001a\u00020Q2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010Á\u0002\u001a\u00020\u0002H\u0016J4\u0010Ã\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\u0007\u0010Ä\u0002\u001a\u00020\u00142\t\u0010Å\u0002\u001a\u0004\u0018\u00010\n2\t\u0010Æ\u0002\u001a\u0004\u0018\u00010\nH\u0016J5\u0010Ç\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\b\u0010\u0001\u001a\u00030È\u00022\t\u0010É\u0002\u001a\u0004\u0018\u00010\n2\t\u0010Ê\u0002\u001a\u0004\u0018\u00010\nH\u0016J-\u0010Ë\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\n\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u00012\n\u0010Á\u0002\u001a\u0005\u0018\u00010\u0002H\u0016J-\u0010Ì\u0002\u001a\u00020r2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010Í\u00022\n\u0010Î\u0002\u001a\u0005\u0018\u00010Ï\u0002H\u0016J\u0015\u0010Ð\u0002\u001a\u00020r2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0016J\t\u0010Ñ\u0002\u001a\u00020QH\u0016J\u0012\u0010Ò\u0002\u001a\u00020r2\u0007\u0010Ó\u0002\u001a\u00020\nH\u0004J\t\u0010Ô\u0002\u001a\u00020rH\u0014J\u0012\u0010Õ\u0002\u001a\u00020r2\u0007\u0010\u0002\u001a\u00020QH\u0004J4\u0010Ö\u0002\u001a\u00020r2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010×\u0002\u001a\u00020Q2\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010À\u0002\u001a\u00020\n2\u0007\u0010Á\u0002\u001a\u00020\u0002J$\u0010Ø\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\n2\u0007\u0010Ù\u0002\u001a\u00020Q2\u0007\u0010§\u0002\u001a\u00020\u0014H\u0014J$\u0010Ú\u0002\u001a\u00020Q2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010Û\u0002\u001a\u00020\u0002H\u0014J\u001d\u0010Ü\u0002\u001a\u00020Q2\b\u0010\u0002\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u0001H\u0014J\u001c\u0010Ü\u0002\u001a\u00020Q2\b\u0010\u0002\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\nH\u0014J-\u0010Ý\u0002\u001a\u00020Q2\u0007\u0010§\u0002\u001a\u00020\u00142\u0007\u0010×\u0002\u001a\u00020Q2\u0007\u0010¨\u0002\u001a\u00020\n2\u0007\u0010À\u0002\u001a\u00020\nH\u0014J\u0010\u0010Þ\u0002\u001a\u00020r2\u0007\u0010Ù\u0002\u001a\u00020QJ\u0007\u0010ß\u0002\u001a\u00020rJ\u0010\u0010ß\u0002\u001a\u00020r2\u0007\u0010ó\u0001\u001a\u00020\nJ\u0010\u0010à\u0002\u001a\u00020r2\u0007\u0010ë\u0001\u001a\u00020ZJ\u0010\u0010á\u0002\u001a\u00020r2\u0007\u0010ë\u0001\u001a\u00020vJ\u0011\u0010â\u0002\u001a\u00020r2\b\u0010î\u0001\u001a\u00030\u0001J\u0014\u0010ã\u0002\u001a\u00020r2\t\b\u0002\u0010ä\u0002\u001a\u00020QH\u0002J\u0012\u0010å\u0002\u001a\u00020Q2\u0007\u0010ð\u0001\u001a\u00020\u0014H\u0004J\t\u0010æ\u0002\u001a\u00020rH\u0002J\u0012\u0010ç\u0002\u001a\u00020r2\u0007\u0010ó\u0001\u001a\u00020\nH\u0002J\t\u0010è\u0002\u001a\u00020rH\u0016J\t\u0010é\u0002\u001a\u00020rH\u0014J\t\u0010ê\u0002\u001a\u00020rH\u0014J\u0007\u0010ë\u0002\u001a\u00020QJ,\u0010ì\u0002\u001a\u00020Q2\b\u0010í\u0002\u001a\u00030ü\u00012\u0007\u0010Ä\u0002\u001a\u00020\u00142\u0007\u0010Å\u0002\u001a\u00020\n2\u0007\u0010Æ\u0002\u001a\u00020\nJ\u001e\u0010î\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010í\u0002\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u0001J*\u0010î\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010í\u0002\u001a\u00030ü\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\n\u0010\u0002\u001a\u0005\u0018\u00010\u0002J\u001a\u0010ï\u0002\u001a\u00020Q2\b\u0010û\u0001\u001a\u00030ü\u00012\u0007\u0010ó\u0001\u001a\u00020\nJ\u001f\u0010ï\u0002\u001a\u00020Q2\n\u0010û\u0001\u001a\u0005\u0018\u00010ü\u00012\n\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001J\u0011\u0010ð\u0002\u001a\u00020r2\b\u0010\u0001\u001a\u00030\u0001J\u001d\u0010ñ\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\n2\t\b\u0002\u0010Ù\u0002\u001a\u00020QH\u0014J'\u0010ò\u0002\u001a\u00030ó\u00022\u0007\u0010ó\u0001\u001a\u00020\n2\t\b\u0002\u0010Ù\u0002\u001a\u00020Q2\t\b\u0002\u0010§\u0002\u001a\u00020\u0014J\t\u0010ô\u0002\u001a\u00020rH\u0004J\u0012\u0010õ\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\nH\u0014J\u0012\u0010ö\u0002\u001a\u00020Q2\u0007\u0010ó\u0001\u001a\u00020\nH\u0014JU\u0010÷\u0002\u001a\u00020r\"\n\b\u0000\u0010ø\u0002*\u00030ù\u00022!\u0010ú\u0002\u001a\u001c\u0012\u0017\u0012\u0015\u0012\u0005\u0012\u0003Hø\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0o0û\u00022\u000e\u0010ü\u0002\u001a\t\u0012\u0004\u0012\u00020\n0ý\u00022\u000b\b\u0002\u0010ó\u0001\u001a\u0004\u0018\u00010\nH\u0002J\t\u0010þ\u0002\u001a\u00020QH\u0014J\t\u0010ÿ\u0002\u001a\u00020QH\u0014J\u0010\u0010ã\u0001\u001a\u00020r2\u0007\u0010ä\u0002\u001a\u00020QR\u001b\u0010\u000e\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0014\u0010!\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0014\u0010%\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0016R\u0014\u0010)\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0016R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0014\u00100\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0016R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010/R\u0014\u00104\u001a\u00020\u0014XD¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u0016R\u001d\u00106\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n07¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u001b\u0010:\u001a\u00020;8DX\u0002¢\u0006\f\n\u0004\b>\u0010\u0012\u001a\u0004\b<\u0010=R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020A0@X\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR!\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020E8BX\u0002¢\u0006\f\n\u0004\bH\u0010\u0012\u001a\u0004\bF\u0010GR\u001a\u0010I\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0010\"\u0004\bK\u0010LR\u001b\u0010M\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\bO\u0010\u0012\u001a\u0004\bN\u0010\u0016R\u0014\u0010P\u001a\u00020QXD¢\u0006\b\n\u0000\u001a\u0004\bR\u0010SR\u001a\u0010T\u001a\u00020QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010S\"\u0004\bV\u0010WR\u001a\u0010X\u001a\b\u0012\u0004\u0012\u00020Z0YX\u0004¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\\R$\u0010^\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0010\"\u0004\b`\u0010LR\u001c\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010d\"\u0004\be\u0010fR\u001d\u0010g\u001a\u0004\u0018\u00010\n8FX\u0002¢\u0006\f\n\u0004\bi\u0010\u0012\u001a\u0004\bh\u0010\u0010R\u0014\u0010j\u001a\u00020k8DX\u0004¢\u0006\u0006\u001a\u0004\bl\u0010mR&\u0010n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020p\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0o0YX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010s\u001a\b\u0012\u0004\u0012\u00020\n0tX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020v0YX\u0004¢\u0006\b\n\u0000\u001a\u0004\bw\u0010\\R\u0014\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00140tX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010y\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\bz\u0010\u0010R\u001a\u0010{\u001a\u00020QX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010S\"\u0004\b}\u0010WR\u0018\u0010~\u001a\b\u0012\u0004\u0012\u00020\n0\tX¤\u0004¢\u0006\u0006\u001a\u0004\b\u0010/R \u0010\u0001\u001a\u00030\u00018FX\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\u0012\u001a\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020QX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010S\"\u0005\b\u0001\u0010WR \u0010\u0001\u001a\u00030\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010YX\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010\\R \u0010\u0001\u001a\u00030\u0001X.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0013\u0010\u0001\u001a\u00020Q¢\u0006\t\n\u0000\u001a\u0005\b\u0001\u0010SR\u0016\u0010\u0001\u001a\u00020Q8DX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010SR\u000f\u0010\u0001\u001a\u00020QX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020Q8DX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010SR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R \u0010\u0001\u001a\u00030\u00018@X\u0002¢\u0006\u000f\n\u0005\b\u0001\u0010\u0012\u001a\u0006\b\u0001\u0010\u0001R \u0010 \u0001\u001a\u00030¡\u00018FX\u0002¢\u0006\u000f\n\u0005\b¤\u0001\u0010\u0012\u001a\u0006\b¢\u0001\u0010£\u0001R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R,\u0010¦\u0001\u001a\u0004\u0018\u00010\n2\t\u0010¥\u0001\u001a\u0004\u0018\u00010\n@DX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b§\u0001\u0010\u0010\"\u0005\b¨\u0001\u0010LR\u001e\u0010©\u0001\u001a\u00020Q8BX\u0002¢\u0006\u000e\n\u0005\b«\u0001\u0010\u0012\u001a\u0005\bª\u0001\u0010SR\u001e\u0010¬\u0001\u001a\u00020Q8BX\u0002¢\u0006\u000e\n\u0005\b®\u0001\u0010\u0012\u001a\u0005\b­\u0001\u0010SR\u0016\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001R(\u0010±\u0001\u001a\u001b\u0012\u0017\u0012\u0015\u0012\u0005\u0012\u00030²\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0o0YX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\n0tX\u0004¢\u0006\u0002\n\u0000R \u0010´\u0001\u001a\u00030µ\u00018BX\u0002¢\u0006\u000f\n\u0005\b¸\u0001\u0010\u0012\u001a\u0006\b¶\u0001\u0010·\u0001R\u0015\u0010¹\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140tX\u0004¢\u0006\u0002\n\u0000R\u0015\u0010º\u0001\u001a\u00030»\u0001¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R \u0010¾\u0001\u001a\u00030¿\u00018FX\u0002¢\u0006\u000f\n\u0005\bÂ\u0001\u0010\u0012\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0015\u0010Ã\u0001\u001a\u00030Ä\u0001¢\u0006\n\n\u0000\u001a\u0006\bÅ\u0001\u0010Æ\u0001R\u001d\u0010Ç\u0001\u001a\u00020QX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÈ\u0001\u0010S\"\u0005\bÉ\u0001\u0010WR\u0016\u0010Ê\u0001\u001a\u00020\n8VX\u0004¢\u0006\u0007\u001a\u0005\bË\u0001\u0010\u0010R\u0016\u0010Ì\u0001\u001a\u00020\u00148DX\u0004¢\u0006\u0007\u001a\u0005\bÍ\u0001\u0010\u0016R\u001d\u0010Î\u0001\u001a\u00020\nX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÏ\u0001\u0010\u0010\"\u0005\bÐ\u0001\u0010LR'\u0010Ñ\u0001\u001a\u00020\n2\u0006\u0010]\u001a\u00020\n@DX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÒ\u0001\u0010\u0010\"\u0005\bÓ\u0001\u0010LR(\u0010Ô\u0001\u001a\u001b\u0012\u0004\u0012\u00020\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020r0q0Y0Õ\u0001X\u0004¢\u0006\u0002\n\u0000R\u001f\u0010Ö\u0001\u001a\f\u0012\u0007\b\u0001\u0012\u00030Ø\u00010×\u0001X¤\u0004¢\u0006\b\u001a\u0006\bÙ\u0001\u0010Ú\u0001R\u001e\u0010Û\u0001\u001a\u00020Q8FX\u0002¢\u0006\u000e\n\u0005\bÝ\u0001\u0010\u0012\u001a\u0005\bÜ\u0001\u0010SR\u001e\u0010Þ\u0001\u001a\u00020Q8FX\u0002¢\u0006\u000e\n\u0005\bà\u0001\u0010\u0012\u001a\u0005\bß\u0001\u0010SR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0000\u001a\u0006\bá\u0001\u0010â\u0001R\u001d\u0010ã\u0001\u001a\u00020QX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bä\u0001\u0010S\"\u0005\bå\u0001\u0010WR\u0015\u0010æ\u0001\u001a\u00030ç\u0001¢\u0006\n\n\u0000\u001a\u0006\bè\u0001\u0010é\u0001¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "Lcom/tencent/mm/plugin/webview/permission/AuthCallback;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "Lcom/tencent/xweb/WebViewClient;", "viewWV", "Lcom/tencent/mm/ui/widget/MMWebView;", "options", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "limitedJsApiSet", "", "", "jsApiPool", "Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;", "(Lcom/tencent/mm/ui/widget/MMWebView;Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;Ljava/util/Set;Lcom/tencent/mm/plugin/webview/jsapi/IWebViewJsApiPool;)V", "BWC_TAG", "getBWC_TAG", "()Ljava/lang/String;", "BWC_TAG$delegate", "Lkotlin/Lazy;", "CONTROLLER_INIT_ENV", "", "getCONTROLLER_INIT_ENV", "()I", "CONTROLLER_INVOKER_READY", "getCONTROLLER_INVOKER_READY", "CONTROLLER_LOAD_DATA", "getCONTROLLER_LOAD_DATA", "CONTROLLER_PROGRESS_CACHE_LOAD_START", "getCONTROLLER_PROGRESS_CACHE_LOAD_START", "CONTROLLER_START_INTENT", "getCONTROLLER_START_INTENT", "PAGE_A8KEY_ERR", "getPAGE_A8KEY_ERR", "PAGE_A8KEY_SUCC", "getPAGE_A8KEY_SUCC", "PAGE_COMMIT_VISIBLE", "getPAGE_COMMIT_VISIBLE", "PAGE_FINISHED", "getPAGE_FINISHED", "PAGE_LOAD_PROGRESS_FULL", "getPAGE_LOAD_PROGRESS_FULL", "PAGE_PROGRESS_NO_FRAME_AUTH_START", "getPAGE_PROGRESS_NO_FRAME_AUTH_START", "PAGE_PROGRESS_SHOW_TIME_OUT", "getPAGE_PROGRESS_SHOW_TIME_OUT", "PAGE_PROGRESS_STATUS", "getPAGE_PROGRESS_STATUS", "()Ljava/util/Set;", "PAGE_PROGRESS_WEBVIEW_START", "getPAGE_PROGRESS_WEBVIEW_START", "PAGE_SPA_STATUS", "getPAGE_SPA_STATUS", "PAGE_SPA_UPDATED", "getPAGE_SPA_UPDATED", "a8KeyHeaders", "", "getA8KeyHeaders", "()Ljava/util/Map;", "a8KeyManager", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "getA8KeyManager", "()Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "a8KeyManager$delegate", "actionsCheckList", "", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "getActionsCheckList", "()Ljava/util/List;", "authCallBack", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "getAuthCallBack", "()Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "authCallBack$delegate", "baseUrl", "getBaseUrl", "setBaseUrl", "(Ljava/lang/String;)V", "binderId", "getBinderId", "binderId$delegate", "canFinishProgress", "", "getCanFinishProgress", "()Z", "clearHistory", "getClearHistory", "setClearHistory", "(Z)V", "clientListeners", "Ljava/util/concurrent/ConcurrentLinkedDeque;", "Lcom/tencent/mm/plugin/webview/core/WebViewClientListener;", "getClientListeners", "()Ljava/util/concurrent/ConcurrentLinkedDeque;", "value", "commitUrl", "getCommitUrl", "setCommitUrl", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "getConn", "()Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "setConn", "(Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;)V", "contentData", "getContentData", "contentData$delegate", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "controllerActionCheckList", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lkotlin/Function0;", "", "controllerActions", "Ljava/util/concurrent/ConcurrentSkipListSet;", "controllerListeners", "Lcom/tencent/mm/plugin/webview/core/WebViewControllerListener;", "getControllerListeners", "controllerStatus", "currentUrl", "getCurrentUrl", "destroyCalled", "getDestroyCalled", "setDestroyCalled", "fileUrlWhiteList", "getFileUrlWhiteList", "handler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getHandler", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "handler$delegate", "hasStartCalled", "getHasStartCalled", "setHasStartCalled", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "interceptors", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor;", "getInterceptors", "invoker", "Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "getInvoker", "()Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;", "setInvoker", "(Lcom/tencent/mm/plugin/webview/stub/WebViewStub_AIDL;)V", "isGettingA8Key", "isInject", "isPerformanceCollected", "isStarted", "jsLoader", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "getJsLoader$webview_sdk_release", "()Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "jsLoader$delegate", "jsapi", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "getJsapi", "()Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "jsapi$delegate", "<set-?>", "loadUrl", "getLoadUrl", "setLoadUrl", "openQuickAppIntercept", "getOpenQuickAppIntercept", "openQuickAppIntercept$delegate", "openQuickAppReport", "getOpenQuickAppReport", "openQuickAppReport$delegate", "getOptions", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "pageActionCheckList", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "pageActions", "pageErrorMonitor", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "getPageErrorMonitor", "()Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "pageErrorMonitor$delegate", "pageStatus", "performanceHelper", "Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "getPerformanceHelper", "()Lcom/tencent/mm/plugin/webview/util/WebViewPerformanceHelper;", "progressBarDelayShowRunnable", "Ljava/lang/Runnable;", "getProgressBarDelayShowRunnable", "()Ljava/lang/Runnable;", "progressBarDelayShowRunnable$delegate", "progressController", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "getProgressController", "()Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "progressFinished", "getProgressFinished", "setProgressFinished", "rawUrl", "getRawUrl", "screenOrientation", "getScreenOrientation", "spaUrl", "getSpaUrl", "setSpaUrl", "startUrl", "getStartUrl", "setStartUrl", "statusListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "stubService", "Ljava/lang/Class;", "Landroid/app/Service;", "getStubService", "()Ljava/lang/Class;", "updateRandomStr", "getUpdateRandomStr", "updateRandomStr$delegate", "useWvUrl", "getUseWvUrl", "useWvUrl$delegate", "getViewWV", "()Lcom/tencent/mm/ui/widget/MMWebView;", "willFinish", "getWillFinish", "setWillFinish", "wvPerm", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "getWvPerm", "()Lcom/tencent/mm/plugin/webview/permission/WebViewPermission;", "addClientListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addControllerListener", "addInterceptor", "interceptor", "addStatusListener", "status", "callback", "canLoadUrl", "url", "canShowRefresh", "checkStatus", "check", "dealSPAUpdate", "destroy", "doAuthCurrentUrl", "doClearHistory", "view", "Lcom/tencent/xweb/WebView;", "doShouldOverrideUrlLoading", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "Lcom/tencent/xweb/WebResourceRequest;", "doUpdateVisitedHistory", "isReload", "enableMinimize", "evaluateJavascript", "script", "Lkotlin/Function1;", "exitTmpl", "forceQuitOnUrlForbidden", "getA8KeyReason", "getCallBackUrl", "getShareUrl", "getStatusListener", "hasStatus", APMidasPluginInfo.LAUNCH_INTERFACE_INIT, "initEnviroment", "initWebViewSettings", "intercept", "Lcom/tencent/xweb/WebResourceResponse;", "webView", "bundle", "Landroid/os/Bundle;", "interceptOverrideUrl", "Lcom/tencent/mm/plugin/webview/core/WebViewInterceptor$OverrideUrlResult;", "isActivityFinished", "isPageCached", "loadCacheUrl", "headers", "", "loadDataWithBaseURL", "data", "mimeType", "encoding", "historyUrl", "httpHeaders", "withoutCache", "needSync", "needSyncGetA8Key", "nullAsBaseUrl", "onAuthEnd", "reason", "reqUrl", "onAuthStart", "onAuthSucc", "onBinded", "onContentRedirect", "content", "onDestroy", "onError", "errType", "errCode", "errMsg", "onFinish", "onFontSizeChanged", "fontSize", "onForceQuit", "onGoBack", "onJsReady", "onPageCommitVisible", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onPerformanceCollect", "onPermissionUpdate", "fullUrl", "response", "onProcessResult", "onReceivedError", OpenSDKTool4Assistant.EXTRA_ERROR_CODE, "description", "failingUrl", "onReceivedHttpAuthRequest", "Lcom/tencent/xweb/HttpAuthHandler;", "host", "realm", "onReceivedHttpError", "onReceivedSslError", "Lcom/tencent/xweb/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onServiceConnected", "onServiceDisconnected", "onShowContent", "html", "onStartLoad", "onStartLoaded", "onUrlRedirect", "forceRedirect", "overrideGetA8Key", "force", "overrideProcessResult", "resp", "overrideUrl", "overrideUrlRedirect", "refresh", "reload", "removeClientListener", "removeControllerListener", "removeInterceptor", "removeInvoker", "floating", "removeStatus", "resetActions", "resetPageActions", "restoreController", "setGetA8KeyParams", "setWebViewPluginClient", "shouldBeFinished", "shouldInterceptLoadError", "webview", "shouldInterceptRequest", "shouldOverrideUrlLoading", "start", "startAuth", "startGetA8Key", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key$Result;", "tryBindService", "validCommitUrl", "validStartUrl", "verifyActions", "T", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "list", "", "set", "", "waitForInject", "waitForReady", "Auth", "Bind", "Companion", "ControllerAction", "Init", "Inject", "Options", "PageAction", "PageLoadEndForCommitNotSupport", "ProgressBarEnd", "ProgressBarStart", "ProgressClientListener", "Ready", "SPAUpdated", "Start", "WebAction", "WebEvent", "WebViewOptions", "webview-sdk_release"})
public abstract class BaseWebViewController extends com.tencent.xweb.ac implements com.tencent.mm.plugin.webview.f.a<bhj> {
    private static final String[] IKP = {"https://statres.quickapp.cn/quickapp/js/routerinline.min.js", "http://fastappjump-drcn.hispace.hicloud.com/", "http://thefatherofsalmon.com/", "http://v2.thefatherofsalmon.com/"};
    public static final b IKQ = new b((byte) 0);
    public final ConcurrentLinkedDeque<k> ICu = new ConcurrentLinkedDeque<>();
    private final kotlin.f IJK = kotlin.g.ah(new a(this));
    private final kotlin.f IJL = kotlin.g.ah(new r(this));
    public String IJM;
    private final kotlin.f IJN = kotlin.g.ah(g.ILd);
    String IJO = "";
    public String IJP = "";
    String IJQ = "";
    protected boolean IJR;
    private boolean IJS;
    public boolean IJT;
    private final kotlin.f IJU = kotlin.g.ah(new ab(this));
    private final kotlin.f IJV = kotlin.g.ah(new ac(this));
    private final kotlin.f IJW = kotlin.g.ah(new s(this));
    public final Map<String, String> IJX = new HashMap();
    private final kotlin.f IJY = kotlin.g.ah(new ai(this));
    public final l IJZ = new aj(this);
    private final ConcurrentLinkedDeque<kotlin.o<PageAction, kotlin.g.a.a<kotlin.x>>> IKA = new ConcurrentLinkedDeque<>();
    private final ConcurrentSkipListSet<Integer> IKB = new ConcurrentSkipListSet<>();
    private final ConcurrentSkipListSet<Integer> IKC = new ConcurrentSkipListSet<>();
    private final ConcurrentSkipListSet<String> IKD = new ConcurrentSkipListSet<>();
    private final ConcurrentSkipListSet<String> IKE = new ConcurrentSkipListSet<>();
    public final boolean IKF = fZr().gbE();
    c IKG;
    private final kotlin.f IKH = kotlin.g.ah(am.ILn);
    private boolean IKI;
    private final kotlin.f IKJ = kotlin.g.ah(an.ILo);
    private final kotlin.f IKK = kotlin.g.ah(ag.ILl);
    private final kotlin.f IKL = kotlin.g.ah(af.ILk);
    final c IKM;
    private Set<String> IKN;
    private com.tencent.mm.plugin.webview.d.e IKO;
    public final com.tencent.mm.plugin.webview.k.j IKa = new com.tencent.mm.plugin.webview.k.j();
    private final kotlin.f IKb = kotlin.g.ah(new ah(this));
    private final ConcurrentLinkedDeque<f> IKc = new ConcurrentLinkedDeque<>();
    public final ConcurrentLinkedDeque<j> IKd = new ConcurrentLinkedDeque<>();
    private final ConcurrentHashMap<Integer, ConcurrentLinkedDeque<kotlin.g.a.a<kotlin.x>>> IKe = new ConcurrentHashMap<>();
    public boolean IKf;
    boolean IKg;
    private final kotlin.f IKh = kotlin.g.ah(new v(this));
    final int IKi = -1;
    public final int IKj = -2;
    public final int IKk = -3;
    protected final int IKl = -10;
    protected final int IKm = -5;
    final int IKn = 1;
    final int IKo = 2;
    final int IKp = 3;
    final int IKq = 4;
    final int IKr = 6;
    final int IKs = 10;
    final int IKt = 11;
    final int IKu = 12;
    final int IKv = 13;
    final Set<Integer> IKw = kotlin.a.ak.setOf((Object[]) new Integer[]{Integer.valueOf(this.IKt), Integer.valueOf(this.IKu), Integer.valueOf(this.IKs), Integer.valueOf(this.IKv)});
    final Set<Integer> IKx = kotlin.a.ak.setOf((Object[]) new Integer[]{Integer.valueOf(this.IKp), Integer.valueOf(this.IKq), Integer.valueOf(this.IKr)});
    private final boolean IKy = true;
    private final ConcurrentLinkedDeque<kotlin.o<ControllerAction, kotlin.g.a.a<kotlin.x>>> IKz = new ConcurrentLinkedDeque<>();
    protected String djt = "";
    protected Intent intent;
    private final kotlin.f lhN = kotlin.g.ah(y.ILh);
    public com.tencent.mm.plugin.webview.stub.e mHh;
    public final com.tencent.mm.plugin.webview.f.g mHi = new com.tencent.mm.plugin.webview.f.g(new ao(this));
    private final List<e> pFO = kotlin.a.j.mutableListOf(new e(kotlin.g.b.aa.bp(Init.class), new h(this)), new e(kotlin.g.b.aa.bp(Inject.class), new j(this)), new e(kotlin.g.b.aa.bp(Bind.class), new k(this)), new e(kotlin.g.b.aa.bp(Auth.class), new l(this)), new e(kotlin.g.b.aa.bp(Ready.class), new m(this)), new e(kotlin.g.b.aa.bp(Start.class), new n(this)), new e(kotlin.g.b.aa.bp(SPAUpdated.class), new o(this)), new e(kotlin.g.b.aa.bp(ProgressBarStart.class), new p(this)), new e(kotlin.g.b.aa.bp(ProgressBarEnd.class), new q(this)), new e(kotlin.g.b.aa.bp(PageLoadEndForCommitNotSupport.class), new i(this)));
    public final MMWebView pGj;

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b%\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "webview-sdk_release"})
    public static abstract class ControllerAction extends WebAction {
        public abstract boolean verify();
    }

    public static final String bj(Intent intent2) {
        return b.bj(intent2);
    }

    private final e fZw() {
        return (e) this.IKb.getValue();
    }

    public final MMHandler bkj() {
        return (MMHandler) this.lhN.getValue();
    }

    public final boolean fZE() {
        return ((Boolean) this.IKH.getValue()).booleanValue();
    }

    public final String fZo() {
        return (String) this.IJK.getValue();
    }

    /* access modifiers changed from: protected */
    public abstract Class<? extends Service> fZp();

    /* access modifiers changed from: protected */
    public abstract Set<String> fZq();

    public final com.tencent.mm.plugin.webview.f.c fZr() {
        return (com.tencent.mm.plugin.webview.f.c) this.IJN.getValue();
    }

    public final com.tencent.mm.plugin.webview.d.k fZt() {
        return (com.tencent.mm.plugin.webview.d.k) this.IJU.getValue();
    }

    public final int fZu() {
        return ((Number) this.IJW.getValue()).intValue();
    }

    public final Runnable fZv() {
        return (Runnable) this.IJY.getValue();
    }

    public final String fZx() {
        return (String) this.IKh.getValue();
    }

    public final com.tencent.mm.plugin.webview.d.h getJsapi() {
        return (com.tencent.mm.plugin.webview.d.h) this.IJV.getValue();
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/core/WebPageErrorMonitor;", "invoke"})
    static final class ah extends kotlin.g.b.q implements kotlin.g.a.a<e> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ah(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ e invoke() {
            AppMethodBeat.i(225015);
            e fZJ = fZJ();
            AppMethodBeat.o(225015);
            return fZJ;
        }

        private e fZJ() {
            AppMethodBeat.i(225016);
            long j2 = -1;
            try {
                j2 = this.IKR.fZs().gdW() ? (long) this.IKR.fZs().gec() : 0;
            } catch (Throwable th) {
                Log.e(this.IKR.fZo(), "Get Uin Error:" + th.getLocalizedMessage());
            }
            e eVar = new e(j2);
            AppMethodBeat.o(225016);
            return eVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final /* synthetic */ class h extends kotlin.g.b.n implements kotlin.g.a.a<kotlin.x> {
        h(BaseWebViewController baseWebViewController) {
            super(0, baseWebViewController);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(224980);
            kotlin.l.b bp = kotlin.g.b.aa.bp(BaseWebViewController.class);
            AppMethodBeat.o(224980);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "initEnviroment";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "initEnviroment()V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224979);
            ((BaseWebViewController) this.SYl).cpc();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224979);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final /* synthetic */ class k extends kotlin.g.b.n implements kotlin.g.a.a<kotlin.x> {
        k(BaseWebViewController baseWebViewController) {
            super(0, baseWebViewController);
        }

        @Override // kotlin.g.b.e
        public final kotlin.l.d Rs() {
            AppMethodBeat.i(224984);
            kotlin.l.b bp = kotlin.g.b.aa.bp(BaseWebViewController.class);
            AppMethodBeat.o(224984);
            return bp;
        }

        @Override // kotlin.l.a, kotlin.g.b.e
        public final String getName() {
            return "onBinded";
        }

        @Override // kotlin.g.b.e
        public final String getSignature() {
            return "onBinded()V";
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224983);
            ((BaseWebViewController) this.SYl).ePr();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224983);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"setConfigCallback", "", "windowManager", "Landroid/view/WindowManager;", "invoke"})
    public static final class z extends kotlin.g.b.q implements kotlin.g.a.b<WindowManager, kotlin.x> {
        public static final z ILi = new z();

        static {
            AppMethodBeat.i(225005);
            AppMethodBeat.o(225005);
        }

        z() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ kotlin.x invoke(WindowManager windowManager) {
            AppMethodBeat.i(225003);
            b(windowManager);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(225003);
            return xVar;
        }

        public static void b(WindowManager windowManager) {
            AppMethodBeat.i(225004);
            kotlin.g.b.p.h(windowManager, "windowManager");
            try {
                Field declaredField = WebView.class.getDeclaredField("mWebViewCore");
                kotlin.g.b.p.g(declaredField, "WebView::class.java.getD…aredField(\"mWebViewCore\")");
                Field declaredField2 = declaredField.getType().getDeclaredField("mBrowserFrame");
                kotlin.g.b.p.g(declaredField2, "field.type.getDeclaredField(\"mBrowserFrame\")");
                Field declaredField3 = declaredField2.getType().getDeclaredField("sConfigCallback");
                kotlin.g.b.p.g(declaredField3, "field.type.getDeclaredField(\"sConfigCallback\")");
                declaredField3.setAccessible(true);
                Object obj = declaredField3.get(null);
                if (obj == null) {
                    AppMethodBeat.o(225004);
                    return;
                }
                Field declaredField4 = declaredField3.getType().getDeclaredField("mWindowManager");
                kotlin.g.b.p.g(declaredField4, "field.type.getDeclaredField(\"mWindowManager\")");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, windowManager);
                AppMethodBeat.o(225004);
            } catch (Exception e2) {
                AppMethodBeat.o(225004);
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, boolean, java.lang.String, java.lang.String, java.lang.Object] */
    @Override // com.tencent.mm.plugin.webview.f.a
    public final /* synthetic */ void a(int i2, boolean z2, String str, String str2, bhj bhj) {
        boolean z3;
        bhj bhj2 = bhj;
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "fullUrl");
        kotlin.g.b.p.h(bhj2, "response");
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "fullUrl");
        if (!aXC(str2)) {
            Iterator<T> it = this.ICu.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().a(i2, z2, str, str2)) {
                        z3 = true;
                        break;
                    }
                } else {
                    z3 = false;
                    break;
                }
            }
        } else {
            Log.f(fZo(), "processGetA8Key qrcode, canLoadUrl fail, url = ".concat(String.valueOf(str2)));
            z3 = true;
        }
        if (!z3) {
            Log.d(fZo(), "onUrlRedirect:" + str + "\nfrom:" + str2);
            a(this, str2, this.IJX, 4);
            Iterator<T> it2 = this.IKd.iterator();
            while (it2.hasNext()) {
                it2.next().a(str, bhj2);
            }
        }
    }

    public BaseWebViewController(MMWebView mMWebView, c cVar, Set<String> set, com.tencent.mm.plugin.webview.d.e eVar) {
        kotlin.g.b.p.h(mMWebView, "viewWV");
        kotlin.g.b.p.h(cVar, "options");
        this.pGj = mMWebView;
        this.IKM = cVar;
        this.IKN = set;
        this.IKO = eVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Options;", "", "webView", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "trust", "", "enableWvSHA1", "fontWithSys", "neverGetA8Key", "getA8keyScene", "", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;ZZZZI)V", "getEnableWvSHA1", "()Z", "getFontWithSys", "getGetA8keyScene", "()I", "setGetA8keyScene", "(I)V", "getNeverGetA8Key", "getTrust", "getWebView", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "webview-sdk_release"})
    public static final class c {
        final f IKS;
        final boolean IKT;
        final boolean IKU;
        final boolean IKV;
        final boolean IKW;
        public int IKX;

        public c() {
            this(null, false, false, false, false, 63);
        }

        public c(f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            kotlin.g.b.p.h(fVar, "webView");
            AppMethodBeat.i(224958);
            this.IKS = fVar;
            this.IKT = z;
            this.IKU = z2;
            this.IKV = z3;
            this.IKW = z4;
            this.IKX = 0;
            AppMethodBeat.o(224958);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ c(com.tencent.mm.plugin.webview.core.BaseWebViewController.f r8, boolean r9, boolean r10, boolean r11, boolean r12, int r13) {
            /*
                r7 = this;
                r6 = 224959(0x36ebf, float:3.15235E-40)
                r4 = 1
                r5 = 0
                r0 = r13 & 1
                if (r0 == 0) goto L_0x0033
                com.tencent.mm.plugin.webview.core.BaseWebViewController$f r1 = new com.tencent.mm.plugin.webview.core.BaseWebViewController$f
                r1.<init>()
            L_0x000e:
                r0 = r13 & 2
                if (r0 == 0) goto L_0x0031
                r2 = r5
            L_0x0013:
                r0 = r13 & 4
                if (r0 == 0) goto L_0x002f
                r3 = r4
            L_0x0018:
                r0 = r13 & 8
                if (r0 == 0) goto L_0x002d
            L_0x001c:
                r0 = r13 & 16
                if (r0 == 0) goto L_0x002b
            L_0x0020:
                r0 = r7
                r0.<init>(r1, r2, r3, r4, r5)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
                com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
                return
            L_0x002b:
                r5 = r12
                goto L_0x0020
            L_0x002d:
                r4 = r11
                goto L_0x001c
            L_0x002f:
                r3 = r10
                goto L_0x0018
            L_0x0031:
                r2 = r9
                goto L_0x0013
            L_0x0033:
                r1 = r8
                goto L_0x000e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.c.<init>(com.tencent.mm.plugin.webview.core.BaseWebViewController$f, boolean, boolean, boolean, boolean, int):void");
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u000f\u0010\bR\u001b\u0010\u0011\u001a\u00020\u00068FX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0012\u0010\b¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebViewOptions;", "", "intent", "Landroid/content/Intent;", "(Landroid/content/Intent;)V", "enableJavascript", "", "getEnableJavascript", "()Z", "enableJavascript$delegate", "Lkotlin/Lazy;", "enablePlugin", "getEnablePlugin", "enablePlugin$delegate", "enableVerticalScroll", "getEnableVerticalScroll", "enableVerticalScroll$delegate", "enableZoom", "getEnableZoom", "enableZoom$delegate", "webview-sdk_release"})
    public static final class f {
        final kotlin.f IKZ;
        final kotlin.f ILa;
        final kotlin.f ILb;
        final kotlin.f ILc;

        public /* synthetic */ f() {
            this(new Intent());
            AppMethodBeat.i(224976);
            AppMethodBeat.o(224976);
        }

        public f(Intent intent) {
            kotlin.g.b.p.h(intent, "intent");
            AppMethodBeat.i(224975);
            this.IKZ = kotlin.g.ah(new b(intent));
            this.ILa = kotlin.g.ah(new d(intent));
            this.ILb = kotlin.g.ah(new a(intent));
            this.ILc = kotlin.g.ah(new c(intent));
            AppMethodBeat.o(224975);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class b extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ Intent $intent;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(Intent intent) {
                super(0);
                this.$intent = intent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(224972);
                Boolean valueOf = Boolean.valueOf(this.$intent.getBooleanExtra("usePlugin", true));
                AppMethodBeat.o(224972);
                return valueOf;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class d extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ Intent $intent;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(Intent intent) {
                super(0);
                this.$intent = intent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(224974);
                Boolean valueOf = Boolean.valueOf(this.$intent.getBooleanExtra("zoom", true));
                AppMethodBeat.o(224974);
                return valueOf;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ Intent $intent;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Intent intent) {
                super(0);
                this.$intent = intent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(224971);
                Boolean valueOf = Boolean.valueOf(this.$intent.getBooleanExtra("useJs", true));
                AppMethodBeat.o(224971);
                return valueOf;
            }
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
        static final class c extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
            final /* synthetic */ Intent $intent;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Intent intent) {
                super(0);
                this.$intent = intent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ Boolean invoke() {
                AppMethodBeat.i(224973);
                Boolean valueOf = Boolean.valueOf(this.$intent.getBooleanExtra("vertical_scroll", true));
                AppMethodBeat.o(224973);
                return valueOf;
            }
        }
    }

    public final com.tencent.mm.plugin.webview.stub.e fZs() {
        com.tencent.mm.plugin.webview.stub.e eVar = this.mHh;
        if (eVar == null) {
            kotlin.g.b.p.btv("invoker");
        }
        return eVar;
    }

    public final Intent getIntent() {
        Intent intent2 = this.intent;
        if (intent2 == null) {
            kotlin.g.b.p.btv("intent");
        }
        return intent2;
    }

    /* access modifiers changed from: protected */
    public final void setIntent(Intent intent2) {
        kotlin.g.b.p.h(intent2, "<set-?>");
        this.intent = intent2;
    }

    public final String getCurrentUrl() {
        return kotlin.n.n.aL(this.IJQ) ? this.IJP : this.IJQ;
    }

    private final String aXw(String str) {
        String str2 = str;
        if ((str2 == null || kotlin.n.n.aL(str2)) || com.tencent.luggage.h.c.a(str, "about:blank", true) || com.tencent.luggage.h.c.a(str, "data:text/html;charset=utf-8", true)) {
            return this.djt;
        }
        return str;
    }

    /* access modifiers changed from: protected */
    public final void aXx(String str) {
        kotlin.g.b.p.h(str, "value");
        if (aiw(str)) {
            Log.d(fZo(), "WebView-Trace startUrl:".concat(String.valueOf(str)));
            this.IJO = str;
        }
    }

    /* access modifiers changed from: protected */
    public final void aXy(String str) {
        kotlin.g.b.p.h(str, "value");
        if (aix(str)) {
            Log.d(fZo(), "WebView-Trace commitUrl:".concat(String.valueOf(str)));
            this.IJP = str;
        }
    }

    /* access modifiers changed from: protected */
    public boolean aiw(String str) {
        kotlin.g.b.p.h(str, "url");
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        if (kotlin.n.n.J(r5, r0, false) == false) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean aix(java.lang.String r5) {
        /*
            r4 = this;
            r1 = 1
            r2 = 0
            java.lang.String r0 = "url"
            kotlin.g.b.p.h(r5, r0)
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = kotlin.n.n.aL(r0)
            if (r0 != 0) goto L_0x003e
            r0 = r1
        L_0x0012:
            if (r0 == 0) goto L_0x0040
            java.lang.String r0 = "data:text/html;charset=utf-8"
            boolean r0 = kotlin.n.n.J(r5, r0, r2)
            if (r0 != 0) goto L_0x0040
            java.lang.String r0 = "about:blank"
            boolean r0 = kotlin.n.n.J(r5, r0, r2)
            if (r0 != 0) goto L_0x0040
            int r0 = r4.IKl
            boolean r0 = r4.afI(r0)
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = com.tencent.mm.plugin.webview.h.a.pFm
            java.lang.String r3 = "ConstantsPreload.HARDCODE_URL"
            kotlin.g.b.p.g(r0, r3)
            boolean r0 = kotlin.n.n.J(r5, r0, r2)
            if (r0 != 0) goto L_0x0040
        L_0x003c:
            r0 = r1
        L_0x003d:
            return r0
        L_0x003e:
            r0 = r2
            goto L_0x0012
        L_0x0040:
            r0 = r2
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.aix(java.lang.String):boolean");
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/webview/core/BaseWebViewController$wvPerm$1", "Lcom/tencent/mm/plugin/webview/permission/WebViewPermission$UrlFetcher;", "getA8keyUrl", "", "getPreverifyUrl", "webview-sdk_release"})
    public static final class ao implements g.b {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        ao(BaseWebViewController baseWebViewController) {
            this.IKR = baseWebViewController;
        }

        @Override // com.tencent.mm.plugin.webview.f.g.b
        public final String fZK() {
            AppMethodBeat.i(225029);
            String currentUrl = this.IKR.getCurrentUrl();
            if (currentUrl != null) {
                if (currentUrl.length() > 0) {
                    String currentUrl2 = this.IKR.getCurrentUrl();
                    AppMethodBeat.o(225029);
                    return currentUrl2;
                }
            }
            String url = this.IKR.pGj.getUrl();
            if (url == null) {
                url = "";
            }
            AppMethodBeat.o(225029);
            return url;
        }

        @Override // com.tencent.mm.plugin.webview.f.g.b
        public final String fZL() {
            return this.IKR.IJP;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/webview/core/BaseWebViewController$progressController$1", "Lcom/tencent/mm/plugin/webview/core/WebViewProgressController;", "delay", "", "mills", "", "finish", "webview-sdk_release"})
    public static final class aj extends l {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        aj(BaseWebViewController baseWebViewController) {
            this.IKR = baseWebViewController;
        }

        @Override // com.tencent.mm.plugin.webview.core.l
        public final void Mc(long j2) {
            AppMethodBeat.i(225019);
            this.IKR.bkj().postDelayed(this.IKR.fZv(), j2);
            AppMethodBeat.o(225019);
        }
    }

    /* access modifiers changed from: protected */
    public final Context getContext() {
        Context context = this.pGj.getContext();
        kotlin.g.b.p.g(context, "viewWV.context");
        return context;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressClientListener;", "Lcom/tencent/mm/ui/widget/WebChromeClientListener;", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "onProgressChanged", "", "view", "Lcom/tencent/xweb/WebView;", "newProgress", "", "webview-sdk_release"})
    final class d extends com.tencent.mm.ui.widget.i {
        /* JADX WARN: Incorrect args count in method signature: ()V */
        public d() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
            if (com.tencent.mm.plugin.webview.core.g.a.fZQ() != false) goto L_0x0042;
         */
        @Override // com.tencent.mm.ui.widget.i
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.xweb.WebView r7, int r8) {
            /*
            // Method dump skipped, instructions count: 226
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.d.a(com.tencent.xweb.WebView, int):void");
        }
    }

    public final void init() {
        fZy();
        afH(this.IKi);
        this.pGj.a(new d());
    }

    /* access modifiers changed from: protected */
    public void cpc() {
        com.tencent.mm.plugin.expansions.a.cMr();
        a(new com.tencent.mm.plugin.webview.c.a());
        a(new com.tencent.mm.plugin.webview.g.a());
        a(new com.tencent.mm.plugin.webview.l.e());
        this.pGj.setWebViewClient(this);
        MMWebView mMWebView = this.pGj;
        z zVar = z.ILi;
        com.tencent.mm.plugin.webview.k.k.h(mMWebView);
        com.tencent.xweb.z settings = mMWebView.getSettings();
        settings.setJavaScriptEnabled(((Boolean) this.IKM.IKS.ILb.getValue()).booleanValue());
        settings.setPluginsEnabled(((Boolean) this.IKM.IKS.IKZ.getValue()).booleanValue());
        settings.hsU();
        settings.setBuiltInZoomControls(((Boolean) this.IKM.IKS.ILa.getValue()).booleanValue());
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.hsN();
        settings.hsM();
        settings.setGeolocationEnabled(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.hsW();
        settings.hsS();
        File dir = mMWebView.getContext().getDir("webviewcache", 0);
        kotlin.g.b.p.g(dir, "context.getDir(\"webviewc…e\", Context.MODE_PRIVATE)");
        settings.setAppCachePath(dir.getAbsolutePath());
        settings.hsR();
        settings.hsT();
        settings.setDatabasePath(com.tencent.mm.loader.j.b.aKA() + "databases/");
        String userAgentString = settings.getUserAgentString();
        kotlin.g.b.p.g(userAgentString, "currentUa");
        if (!kotlin.n.n.e(userAgentString, " MicroMessenger/")) {
            com.tencent.mm.plugin.appbrand.luggage.b.f fVar = (p.a) com.tencent.luggage.a.e.M(p.a.class);
            if (fVar == null) {
                fVar = new com.tencent.mm.plugin.appbrand.luggage.b.f(mMWebView.getContext());
            }
            e.a aVar = com.tencent.mm.plugin.webview.k.e.JBw;
            kotlin.g.b.p.h(userAgentString, "prefix");
            e.a.aTI().putString("key_web_prefetch_ua", userAgentString);
            settings.setUserAgentString(com.tencent.mm.plugin.appbrand.ac.p.a(mMWebView.getContext(), userAgentString, fVar));
        }
        if (!((Boolean) this.IKM.IKS.ILc.getValue()).booleanValue()) {
            mMWebView.setVerticalScrollBarEnabled(false);
            mMWebView.setHorizontalScrollBarEnabled(false);
        }
        com.tencent.xweb.c.hsp().hsq();
        com.tencent.xweb.c.hsp().e(mMWebView);
        z zVar2 = z.ILi;
        Object systemService = mMWebView.getContext().getSystemService("window");
        if (systemService == null) {
            throw new kotlin.t("null cannot be cast to non-null type android.view.WindowManager");
        }
        z.b((WindowManager) systemService);
        if (this.pGj.gZa()) {
            String url = this.pGj.getUrl();
            if (url == null) {
                url = "";
            }
            aXy(url);
        }
        this.IKa.bN("onTryBindServiceStart", System.currentTimeMillis());
        Log.i(fZo(), "WebView-Trace tryBindService");
        m mVar = m.INc;
        m.a(true, fZp(), new al(this));
        this.IKa.bN("onTryBindServiceEnd", System.currentTimeMillis());
    }

    public final ConcurrentLinkedDeque<kotlin.g.a.a<kotlin.x>> afG(int i2) {
        ConcurrentLinkedDeque<kotlin.g.a.a<kotlin.x>> concurrentLinkedDeque = this.IKe.get(Integer.valueOf(i2));
        if (concurrentLinkedDeque != null) {
            return concurrentLinkedDeque;
        }
        ConcurrentLinkedDeque<kotlin.g.a.a<kotlin.x>> concurrentLinkedDeque2 = new ConcurrentLinkedDeque<>();
        this.IKe.put(Integer.valueOf(i2), concurrentLinkedDeque2);
        return concurrentLinkedDeque2;
    }

    public final void a(f fVar) {
        kotlin.g.b.p.h(fVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.IKc.contains(fVar)) {
            this.IKc.add(fVar);
        }
    }

    public final void b(f fVar) {
        kotlin.g.b.p.h(fVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.IKc.contains(fVar)) {
            this.IKc.remove(fVar);
        }
    }

    public final synchronized void a(j jVar) {
        kotlin.g.b.p.h(jVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.IKd.contains(jVar)) {
            BaseWebViewController baseWebViewController = this;
            kotlin.g.b.p.h(baseWebViewController, "<set-?>");
            jVar.controller = baseWebViewController;
            this.IKd.add(jVar);
            if (this.IKE.contains(kotlin.g.b.aa.bp(Bind.class).getSimpleName())) {
                Log.i(fZo(), "Abe-Debug Patch Call onBind");
                jVar.ePr();
            }
        }
    }

    public final synchronized void b(j jVar) {
        kotlin.g.b.p.h(jVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (this.IKd.contains(jVar)) {
            this.IKd.remove(jVar);
        }
    }

    public final void a(k kVar) {
        kotlin.g.b.p.h(kVar, "interceptor");
        this.ICu.add(kVar);
        f gai = kVar.gai();
        if (gai != null) {
            a(gai);
        }
        j gaj = kVar.gaj();
        if (gaj != null) {
            a(gaj);
        }
        kVar.k(this);
    }

    public final void b(k kVar) {
        kotlin.g.b.p.h(kVar, "interceptor");
        this.ICu.remove(kVar);
        f gai = kVar.gai();
        if (gai != null) {
            b(gai);
        }
        j gaj = kVar.gaj();
        if (gaj != null) {
            b(gaj);
        }
    }

    public String coX() {
        try {
            Intent intent2 = this.intent;
            if (intent2 == null) {
                kotlin.g.b.p.btv("intent");
            }
            return b.bj(intent2);
        } catch (Exception e2) {
            Log.e(fZo(), String.valueOf(e2.getMessage()));
            onFinish();
            return "";
        }
    }

    public final void aB(Intent intent2) {
        kotlin.g.b.p.h(intent2, "intent");
        Log.i(fZo(), "start");
        this.IJR = true;
        this.intent = intent2;
        com.tencent.mm.plugin.webview.f.g gVar = this.mHi;
        Parcelable parcelableExtra = intent2.getParcelableExtra("hardcode_jspermission");
        if (!(parcelableExtra instanceof JsapiPermissionWrapper)) {
            parcelableExtra = null;
        }
        JsapiPermissionWrapper jsapiPermissionWrapper = (JsapiPermissionWrapper) parcelableExtra;
        Parcelable parcelableExtra2 = intent2.getParcelableExtra("hardcode_general_ctrl");
        if (!(parcelableExtra2 instanceof GeneralControlWrapper)) {
            parcelableExtra2 = null;
        }
        gVar.a(jsapiPermissionWrapper, (GeneralControlWrapper) parcelableExtra2);
        this.IKa.JBP = intent2.getLongExtra("startTime", 0);
        kotlinx.coroutines.f.b(bn.TUK, (kotlin.d.f) null, new ak(this, null), 3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.tencent.mm.plugin.webview.core.BaseWebViewController */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(BaseWebViewController baseWebViewController, String str, Map map, int i2) {
        if ((i2 & 2) != 0) {
            map = null;
        }
        baseWebViewController.loadUrl(str, map, false);
    }

    public void loadUrl(String str, Map<String, String> map, boolean z2) {
        boolean z3 = false;
        kotlin.g.b.p.h(str, "url");
        Log.i(fZo(), "WebView-Trace loadUrl url ".concat(String.valueOf(str)));
        if (z2) {
            this.pGj.loadUrl(str, kotlin.a.ae.g(kotlin.s.U("Pragma", "no-cache"), kotlin.s.U("Cache-Control", "no-cache")));
            return;
        }
        if (map == null || map.isEmpty()) {
            z3 = true;
        }
        if (z3) {
            this.pGj.loadUrl(str);
        } else {
            this.pGj.loadUrl(str, map);
        }
    }

    public final void L(String str, Map<String, String> map) {
        kotlin.g.b.p.h(str, "baseUrl");
        Log.i(fZo(), "WebView-Trace loadCacheUrl baseUrl ".concat(String.valueOf(str)));
        this.djt = str;
        afH(this.IKm);
        this.pGj.loadUrl(str, map);
        aXy(str);
        afH(this.IKl);
        com.tencent.f.h.RTc.aV(new ad(this));
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ad implements Runnable {
        final /* synthetic */ BaseWebViewController IKR;

        ad(BaseWebViewController baseWebViewController) {
            this.IKR = baseWebViewController;
        }

        public final void run() {
            AppMethodBeat.i(225009);
            this.IKR.bkj().postUIDelayed(this.IKR.fZv(), 500);
            AppMethodBeat.o(225009);
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Init;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
    protected static final class Init extends ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(224956);
            boolean waitFor = waitFor(getController().IKi);
            AppMethodBeat.o(224956);
            return waitFor;
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Start;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
    public static final class Start extends ControllerAction {
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
            if ((r0 == null || kotlin.n.n.aL(r0)) == false) goto L_0x0042;
         */
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean verify() {
            /*
                r5 = this;
                r4 = 224966(0x36ec6, float:3.15245E-40)
                r1 = 1
                r2 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.i(r4)
                com.tencent.mm.plugin.webview.core.BaseWebViewController r3 = r5.getController()
                int r0 = r3.IKk
                boolean r0 = r5.waitFor(r0)
                if (r0 == 0) goto L_0x004b
                boolean r0 = r3.cpe()
                if (r0 == 0) goto L_0x0022
                int r0 = r3.IKj
                boolean r0 = r5.waitFor(r0)
                if (r0 == 0) goto L_0x004b
            L_0x0022:
                java.lang.String r0 = r3.coX()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                int r0 = r0.length()
                if (r0 <= 0) goto L_0x0047
                r0 = r1
            L_0x002f:
                if (r0 != 0) goto L_0x0042
                java.lang.String r0 = r3.fZx()
                java.lang.CharSequence r0 = (java.lang.CharSequence) r0
                if (r0 == 0) goto L_0x003f
                boolean r0 = kotlin.n.n.aL(r0)
                if (r0 == 0) goto L_0x0049
            L_0x003f:
                r0 = r1
            L_0x0040:
                if (r0 != 0) goto L_0x004b
            L_0x0042:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                r0 = r1
            L_0x0046:
                return r0
            L_0x0047:
                r0 = r2
                goto L_0x002f
            L_0x0049:
                r0 = r2
                goto L_0x0040
            L_0x004b:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r4)
                r0 = r2
                goto L_0x0046
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.Start.verify():boolean");
        }
    }

    /* access modifiers changed from: protected */
    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Bind;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "()V", "verify", "", "webview-sdk_release"})
    public static final class Bind extends ControllerAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.ControllerAction
        public final boolean verify() {
            AppMethodBeat.i(224954);
            BaseWebViewController controller = getController();
            if (!waitFor(controller.IKk) || !waitFor(controller.IKj)) {
                AppMethodBeat.o(224954);
                return false;
            }
            AppMethodBeat.o(224954);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean coZ() {
        return false;
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Inject;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class Inject extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224957);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (((controller.pGj.gZa() || waitFor(controller.IKs, str) || (waitFor(controller.IKt, str) && waitFor(controller.IKv, str))) && waitFor(controller.IKj) && (controller.IKM.IKW || controller.mHi.has(str) || waitFor(controller.IKn, str))) || controller.coZ()) {
                AppMethodBeat.o(224957);
                return true;
            }
            AppMethodBeat.o(224957);
            return false;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Auth;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class Auth extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224952);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!waitFor(kotlin.g.b.aa.bp(Inject.class), str) || !waitFor(controller.IKj) || (!controller.IKM.IKW && !controller.mHi.has(str) && !waitFor(controller.IKn, str))) {
                AppMethodBeat.o(224952);
                return false;
            }
            AppMethodBeat.o(224952);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean cpa() {
        return false;
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Ready;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class Ready extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224964);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if ((!waitFor(kotlin.g.b.aa.bp(Start.class)) || !waitFor(kotlin.g.b.aa.bp(Auth.class), str) || (!waitFor(controller.IKt, str) && !controller.pGj.gZa())) && !controller.cpa()) {
                AppMethodBeat.o(224964);
                return false;
            }
            AppMethodBeat.o(224964);
            return true;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$SPAUpdated;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "keep", "", "getKeep", "()Z", "verify", "url", "", "webview-sdk_release"})
    protected static final class SPAUpdated extends PageAction {
        private final boolean keep = true;

        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.WebAction
        public final boolean getKeep() {
            return this.keep;
        }

        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224965);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!waitFor(kotlin.g.b.aa.bp(Ready.class), str) || !waitFor(controller.IKu, str)) {
                AppMethodBeat.o(224965);
                return false;
            }
            AppMethodBeat.o(224965);
            return true;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarStart;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class ProgressBarStart extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224962);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!waitFor(kotlin.g.b.aa.bp(Start.class)) || ((controller.afI(controller.IKm) || (!waitFor(controller.IKq, str) && !waitFor(controller.IKp, str))) && (waitFor(kotlin.g.b.aa.bp(ProgressBarEnd.class), str) || !controller.afI(controller.IKm) || !waitFor(controller.IKr, str)))) {
                AppMethodBeat.o(224962);
                return false;
            }
            AppMethodBeat.o(224962);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public boolean coY() {
        return this.IKy;
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ProgressBarEnd;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class ProgressBarEnd extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224961);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!controller.coY() || (!controller.cpa() && !waitFor(kotlin.g.b.aa.bp(Ready.class), str) && !waitFor(controller.IKt, str) && !waitFor(controller.IKs, str) && !waitFor(controller.IKo, str))) {
                AppMethodBeat.o(224961);
                return false;
            }
            AppMethodBeat.o(224961);
            return true;
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageLoadEndForCommitNotSupport;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "()V", "verify", "", "url", "", "webview-sdk_release"})
    protected static final class PageLoadEndForCommitNotSupport extends PageAction {
        @Override // com.tencent.mm.plugin.webview.core.BaseWebViewController.PageAction
        public final boolean verify(String str) {
            AppMethodBeat.i(224960);
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController controller = getController();
            if (!waitFor(kotlin.g.b.aa.bp(Start.class)) || !waitFor(controller.IKt, str) || !waitFor(controller.IKv, str)) {
                AppMethodBeat.o(224960);
                return false;
            }
            AppMethodBeat.o(224960);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public List<e> cpb() {
        return this.pFO;
    }

    public final synchronized void afH(int i2) {
        if (!fZD()) {
            com.tencent.f.h.RTc.aV(new t(this, i2));
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class t implements Runnable {
        final /* synthetic */ BaseWebViewController IKR;
        final /* synthetic */ int ILe;

        t(BaseWebViewController baseWebViewController, int i2) {
            this.IKR = baseWebViewController;
            this.ILe = i2;
        }

        public final void run() {
            boolean z = false;
            AppMethodBeat.i(224995);
            boolean z2 = this.ILe < 0;
            if (!kotlin.aa.SXc || z2) {
                Log.i(this.IKR.fZo(), "checkStatus:" + this.ILe + " to [" + kotlin.a.j.a(this.IKR.IKC, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKB, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKD, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + ']');
                this.IKR.IKC.add(Integer.valueOf(this.ILe));
                this.IKR.a((BaseWebViewController) this.IKR.IKz, (Iterable) this.IKR.IKE, (Set) null);
                String str = this.IKR.IJO;
                if (str == null || kotlin.n.n.aL(str)) {
                    z = true;
                }
                if (!z) {
                    this.IKR.a((BaseWebViewController) this.IKR.IKA, (Iterable) this.IKR.IKD, (Set) this.IKR.IJO);
                }
                kotlin.a.j.a((Iterable) this.IKR.afG(this.ILe), (kotlin.g.a.b) AnonymousClass1.ILf);
                AppMethodBeat.o(224995);
                return;
            }
            AssertionError assertionError = new AssertionError("Assertion failed");
            AppMethodBeat.o(224995);
            throw assertionError;
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void cR(int i2, String str) {
        kotlin.g.b.p.h(str, "url");
        if (!fZD()) {
            com.tencent.f.h.RTc.aV(new u(this, i2, str));
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class u implements Runnable {
        final /* synthetic */ BaseWebViewController IKR;
        final /* synthetic */ int ILe;
        final /* synthetic */ String mkH;

        u(BaseWebViewController baseWebViewController, int i2, String str) {
            this.IKR = baseWebViewController;
            this.ILe = i2;
            this.mkH = str;
        }

        public final void run() {
            boolean z;
            AppMethodBeat.i(224996);
            if (this.ILe > 0) {
                String str = this.mkH;
                if (!(str == null || kotlin.n.n.aL(str))) {
                    z = true;
                    if (!kotlin.aa.SXc && !z) {
                        AssertionError assertionError = new AssertionError("Assertion failed");
                        AppMethodBeat.o(224996);
                        throw assertionError;
                    } else if (!kotlin.g.b.p.j(this.mkH, this.IKR.IJO) || ((this.IKR.IKw.contains(Integer.valueOf(this.ILe)) && kotlin.g.b.p.j(this.mkH, this.IKR.IJQ)) || this.IKR.IKx.contains(Integer.valueOf(this.ILe)))) {
                        Log.i(this.IKR.fZo(), "checkStatus:" + this.ILe + ' ' + this.mkH + " to [" + kotlin.a.j.a(this.IKR.IKC, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKB, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKD, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + ']');
                        this.IKR.IKB.add(Integer.valueOf(this.ILe));
                        this.IKR.a((BaseWebViewController) this.IKR.IKA, (Iterable) this.IKR.IKD, (Set) this.IKR.IJO);
                        AppMethodBeat.o(224996);
                    } else {
                        Log.w(this.IKR.fZo(), "checkStatus skip: " + this.ILe + ", url=" + this.mkH + ", startUrl=" + this.IKR.IJO);
                        AppMethodBeat.o(224996);
                        return;
                    }
                }
            }
            z = false;
            if (!kotlin.aa.SXc) {
            }
            if (!kotlin.g.b.p.j(this.mkH, this.IKR.IJO)) {
            }
            Log.i(this.IKR.fZo(), "checkStatus:" + this.ILe + ' ' + this.mkH + " to [" + kotlin.a.j.a(this.IKR.IKC, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKB, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] [" + kotlin.a.j.a(this.IKR.IKD, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + ']');
            this.IKR.IKB.add(Integer.valueOf(this.ILe));
            this.IKR.a((BaseWebViewController) this.IKR.IKA, (Iterable) this.IKR.IKD, (Set) this.IKR.IJO);
            AppMethodBeat.o(224996);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebEvent;", "", NativeProtocol.WEB_DIALOG_ACTION, "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "block", "Lkotlin/Function0;", "", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)V", "getAction", "()Lkotlin/reflect/KClass;", "getBlock", "()Lkotlin/jvm/functions/Function0;", "component1", "component2", "copy", "equals", "", FacebookRequestErrorClassification.KEY_OTHER, "hashCode", "", "toString", "", "webview-sdk_release"})
    public static final class e {
        final kotlin.l.b<? extends WebAction> IKY;
        final kotlin.g.a.a<kotlin.x> icG;

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (kotlin.g.b.p.j(r3.icG, r4.icG) != false) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r2 = 224970(0x36eca, float:3.1525E-40)
                com.tencent.matrix.trace.core.AppMethodBeat.i(r2)
                if (r3 == r4) goto L_0x0022
                boolean r0 = r4 instanceof com.tencent.mm.plugin.webview.core.BaseWebViewController.e
                if (r0 == 0) goto L_0x0027
                com.tencent.mm.plugin.webview.core.BaseWebViewController$e r4 = (com.tencent.mm.plugin.webview.core.BaseWebViewController.e) r4
                kotlin.l.b<? extends com.tencent.mm.plugin.webview.core.BaseWebViewController$WebAction> r0 = r3.IKY
                kotlin.l.b<? extends com.tencent.mm.plugin.webview.core.BaseWebViewController$WebAction> r1 = r4.IKY
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
                kotlin.g.a.a<kotlin.x> r0 = r3.icG
                kotlin.g.a.a<kotlin.x> r1 = r4.icG
                boolean r0 = kotlin.g.b.p.j(r0, r1)
                if (r0 == 0) goto L_0x0027
            L_0x0022:
                r0 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
            L_0x0026:
                return r0
            L_0x0027:
                r0 = 0
                com.tencent.matrix.trace.core.AppMethodBeat.o(r2)
                goto L_0x0026
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.e.equals(java.lang.Object):boolean");
        }

        public final int hashCode() {
            int i2 = 0;
            AppMethodBeat.i(224969);
            kotlin.l.b<? extends WebAction> bVar = this.IKY;
            int hashCode = (bVar != null ? bVar.hashCode() : 0) * 31;
            kotlin.g.a.a<kotlin.x> aVar = this.icG;
            if (aVar != null) {
                i2 = aVar.hashCode();
            }
            int i3 = hashCode + i2;
            AppMethodBeat.o(224969);
            return i3;
        }

        public final String toString() {
            AppMethodBeat.i(224968);
            String str = "WebEvent(action=" + this.IKY + ", block=" + this.icG + ")";
            AppMethodBeat.o(224968);
            return str;
        }

        public e(kotlin.l.b<? extends WebAction> bVar, kotlin.g.a.a<kotlin.x> aVar) {
            kotlin.g.b.p.h(bVar, NativeProtocol.WEB_DIALOG_ACTION);
            kotlin.g.b.p.h(aVar, "block");
            AppMethodBeat.i(224967);
            this.IKY = bVar;
            this.icG = aVar;
            AppMethodBeat.o(224967);
        }
    }

    public final synchronized boolean afI(int i2) {
        boolean z2 = i2 < 0;
        if (kotlin.aa.SXc && !z2) {
            throw new AssertionError("Assertion failed");
        }
        return this.IKC.contains(Integer.valueOf(i2));
    }

    private synchronized boolean afJ(int i2) {
        boolean z2 = i2 < 0;
        if (kotlin.aa.SXc && !z2) {
            throw new AssertionError("Assertion failed");
        }
        return this.IKC.remove(Integer.valueOf(i2));
    }

    /* access modifiers changed from: protected */
    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b%\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "()V", "verify", "", "url", "", "waitFor", "status", "", "webview-sdk_release"})
    public static abstract class PageAction extends WebAction {
        public abstract boolean verify(String str);

        public final boolean waitFor(int i2, String str) {
            kotlin.g.b.p.h(str, "url");
            return (kotlin.g.b.p.j(str, getController().IJO) || getController().IKx.contains(Integer.valueOf(i2))) && getController().IKB.contains(Integer.valueOf(i2));
        }
    }

    @Keep
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b%\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\r\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011J\u001e\u0010\r\u001a\u00020\n2\u000e\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$WebAction;", "", "()V", "controller", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "getController", "()Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;", "setController", "(Lcom/tencent/mm/plugin/webview/core/BaseWebViewController;)V", "keep", "", "getKeep", "()Z", "waitFor", "status", "", "clazz", "Lkotlin/reflect/KClass;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$ControllerAction;", "Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$PageAction;", "url", "", "webview-sdk_release"})
    public static abstract class WebAction {
        public BaseWebViewController controller;
        private final boolean keep;

        public boolean getKeep() {
            return this.keep;
        }

        public final boolean waitFor(int i2) {
            BaseWebViewController baseWebViewController = this.controller;
            if (baseWebViewController == null) {
                kotlin.g.b.p.btv("controller");
            }
            return baseWebViewController.IKC.contains(Integer.valueOf(i2));
        }

        public final boolean waitFor(kotlin.l.b<? extends ControllerAction> bVar) {
            kotlin.g.b.p.h(bVar, "clazz");
            BaseWebViewController baseWebViewController = this.controller;
            if (baseWebViewController == null) {
                kotlin.g.b.p.btv("controller");
            }
            return baseWebViewController.IKE.contains(bVar.getSimpleName());
        }

        public final boolean waitFor(kotlin.l.b<? extends PageAction> bVar, String str) {
            kotlin.g.b.p.h(bVar, "clazz");
            kotlin.g.b.p.h(str, "url");
            BaseWebViewController baseWebViewController = this.controller;
            if (baseWebViewController == null) {
                kotlin.g.b.p.btv("controller");
            }
            if (kotlin.g.b.p.j(str, baseWebViewController.IJO)) {
                BaseWebViewController baseWebViewController2 = this.controller;
                if (baseWebViewController2 == null) {
                    kotlin.g.b.p.btv("controller");
                }
                if (baseWebViewController2.IKD.contains(bVar.getSimpleName())) {
                    return true;
                }
            }
            return false;
        }

        public final BaseWebViewController getController() {
            BaseWebViewController baseWebViewController = this.controller;
            if (baseWebViewController == null) {
                kotlin.g.b.p.btv("controller");
            }
            return baseWebViewController;
        }

        public final void setController(BaseWebViewController baseWebViewController) {
            kotlin.g.b.p.h(baseWebViewController, "<set-?>");
            this.controller = baseWebViewController;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final synchronized <T extends WebAction> void a(Iterable<? extends kotlin.o<? extends T, ? extends kotlin.g.a.a<kotlin.x>>> iterable, Set<String> set, String str) {
        boolean verify;
        Iterator<? extends kotlin.o<? extends T, ? extends kotlin.g.a.a<kotlin.x>>> it = iterable.iterator();
        while (it.hasNext()) {
            kotlin.o oVar = (kotlin.o) it.next();
            A a2 = oVar.first;
            B b2 = oVar.second;
            if (a2 instanceof PageAction) {
                verify = str != null && a2.verify(str);
            } else {
                verify = a2 instanceof ControllerAction ? a2.verify() : false;
            }
            if (verify) {
                Log.i(fZo(), "verify WebAction: " + kotlin.g.b.aa.bp(a2.getClass()).getSimpleName() + " start");
                if (!a2.getKeep()) {
                    it.remove();
                }
                b2.invoke();
                String simpleName = kotlin.g.b.aa.bp(a2.getClass()).getSimpleName();
                if (simpleName == null) {
                    simpleName = "";
                }
                set.add(simpleName);
                Log.v(fZo(), "verifyActions: " + kotlin.g.b.aa.bp(a2.getClass()).getSimpleName() + " end");
            }
        }
    }

    private final synchronized void fZy() {
        Log.i(fZo(), "resetActions");
        this.IKC.clear();
        this.IKE.clear();
        this.IKz.clear();
        this.IKB.clear();
        this.IKD.clear();
        this.IKA.clear();
        try {
            for (T t2 : cpb()) {
                Object d2 = kotlin.l.a.c.d(t2.IKY);
                ((WebAction) d2).setController(this);
                WebAction webAction = (WebAction) d2;
                if (webAction instanceof ControllerAction) {
                    this.IKz.add(kotlin.s.U(webAction, t2.icG));
                } else if (webAction instanceof PageAction) {
                    this.IKA.add(kotlin.s.U(webAction, t2.icG));
                }
            }
        } catch (Exception e2) {
            Log.i(fZo(), "resetActions ex" + e2.getMessage());
        }
    }

    private final synchronized void aXz(String str) {
        Log.i(fZo(), "resetPageActions clear status:" + str + ", [" + kotlin.a.j.a(this.IKB, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + "] actions: [" + kotlin.a.j.a(this.IKD, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (kotlin.g.a.b) null, 62) + ']');
        this.IKB.clear();
        this.IKD.clear();
        this.IKA.clear();
        this.IKg = false;
        for (T t2 : cpb()) {
            Object d2 = kotlin.l.a.c.d(t2.IKY);
            ((WebAction) d2).setController(this);
            WebAction webAction = (WebAction) d2;
            if (webAction instanceof PageAction) {
                this.IKA.add(kotlin.s.U(webAction, t2.icG));
            }
        }
        aXx(str);
        this.IJQ = "";
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean isStarted() {
        return this.IKE.contains(kotlin.g.b.aa.bp(Start.class).getSimpleName());
    }

    /* access modifiers changed from: protected */
    public final synchronized boolean fZz() {
        return this.IKD.contains(kotlin.g.b.aa.bp(Inject.class).getSimpleName());
    }

    /* access modifiers changed from: protected */
    public void cpd() {
    }

    /* access modifiers changed from: protected */
    public void fZA() {
    }

    /* access modifiers changed from: protected */
    public boolean cpe() {
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r0 != false) goto L_0x0038;
     */
    @Override // com.tencent.xweb.ac
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(com.tencent.xweb.WebView r6, java.lang.String r7) {
        /*
        // Method dump skipped, instructions count: 116
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.a(com.tencent.xweb.WebView, java.lang.String):boolean");
    }

    @Override // com.tencent.xweb.ac
    public final boolean e(WebView webView, WebResourceRequest webResourceRequest) {
        k.a aVar;
        boolean z2;
        boolean z3 = false;
        if (webResourceRequest == null || webView == null) {
            return false;
        }
        kotlin.g.b.p.h(webView, "webView");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        kotlin.g.b.p.h(webView, "webView");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Iterator<T> it = this.ICu.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = new k.a(false, false);
                break;
            }
            aVar = it.next().c(webView, webResourceRequest);
            if (aVar.INa) {
                break;
            }
        }
        if (aVar.INa) {
            z2 = aVar.result;
        } else {
            z2 = false;
        }
        if (z2) {
            z3 = true;
        }
        if (!z3) {
            return super.e(webView, webResourceRequest);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean aK(String str, boolean z2) {
        kotlin.g.b.p.h(str, "url");
        return a(this, str, z2, 0, 4) == c.a.WILL_GET;
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        kotlin.g.b.p.h(webView, "webview");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        WebResourceResponse b2 = b(webView, webResourceRequest, bundle);
        return b2 == null ? super.a(webView, webResourceRequest, bundle) : b2;
    }

    @Override // com.tencent.xweb.ac
    public final boolean b(WebView webView, int i2, String str, String str2) {
        kotlin.g.b.p.h(webView, "webview");
        kotlin.g.b.p.h(str, "description");
        kotlin.g.b.p.h(str2, "failingUrl");
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            it.next().c(webView, i2, str, str2);
        }
        return super.b(webView, i2, str, str2);
    }

    @Override // com.tencent.xweb.ac
    public final void a(WebView webView, com.tencent.xweb.j jVar, String str, String str2) {
        kotlin.g.b.p.h(jVar, "handler");
        super.a(webView, jVar, str, str2);
        com.tencent.mm.plugin.report.service.h.INSTANCE.n(155, 35, 1);
    }

    @Override // com.tencent.xweb.ac
    public void b(WebView webView, String str, Bitmap bitmap) {
        kotlin.g.b.p.h(webView, "view");
        kotlin.g.b.p.h(str, "url");
        if (fZD()) {
            Log.w(fZo(), "ActivityFinished");
            return;
        }
        Context activityContextIfHas = this.pGj.getActivityContextIfHas();
        if (!(activityContextIfHas instanceof Activity)) {
            activityContextIfHas = null;
        }
        Activity activity = (Activity) activityContextIfHas;
        if (activity != null) {
            Intent intent2 = activity.getIntent();
            kotlin.g.b.p.g(intent2, "it.intent");
            this.intent = intent2;
        }
        cR(this.IKp, str);
        Log.i(fZo(), "WebView-Trace onPageStarted: ".concat(String.valueOf(str)));
        this.IKg = false;
        this.IJM = str;
        aXz(str);
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.i(webView, Yc(str));
            }
        }
        super.b(webView, str, bitmap);
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void by(int i2, String str) {
        kotlin.g.b.p.h(str, "reqUrl");
        this.IKa.bN("getA8KeyStart", System.currentTimeMillis());
        if (i2 != 5) {
            cR(this.IKq, str);
        }
        if (!kotlin.g.b.p.j(this.IJQ, str)) {
            com.tencent.f.h.RTc.aV(new ae(this, i2, str));
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class ae implements Runnable {
        final /* synthetic */ BaseWebViewController IKR;
        final /* synthetic */ int kVT;
        final /* synthetic */ String pGq;

        ae(BaseWebViewController baseWebViewController, int i2, String str) {
            this.IKR = baseWebViewController;
            this.kVT = i2;
            this.pGq = str;
        }

        public final void run() {
            AppMethodBeat.i(225010);
            Iterator<T> it = this.IKR.IKd.iterator();
            while (it.hasNext()) {
                it.next().by(this.kVT, this.pGq);
            }
            AppMethodBeat.o(225010);
        }
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void bx(int i2, String str) {
        kotlin.g.b.p.h(str, "reqUrl");
        this.IKa.bN("getA8KeyEnd", System.currentTimeMillis());
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().aXN(str);
        }
    }

    public static /* synthetic */ c.a a(BaseWebViewController baseWebViewController, String str, boolean z2, int i2, int i3) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = baseWebViewController.aXA(str);
        }
        return baseWebViewController.k(str, z2, i2);
    }

    public final c.a k(String str, boolean z2, int i2) {
        kotlin.g.b.p.h(str, "url");
        if (this.IKM.IKW) {
            Log.w(fZo(), "startGetA8Key neverGetA8Key ".concat(String.valueOf(str)));
            return c.a.NO_NEED;
        }
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            if (it.next().aXP(str)) {
                return c.a.INTERCEPTED;
            }
        }
        c.a a2 = fZr().a(str, z2, i2, (com.tencent.mm.plugin.webview.f.f) this.IJL.getValue());
        kotlin.g.b.p.g(a2, "a8KeyManager.startGetA8K…ce, reason, authCallBack)");
        return a2;
    }

    private final int aXA(String str) {
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            int aXA = it.next().aXA(str);
            if (aXA != -1) {
                return aXA;
            }
        }
        return fZr().aZH(str);
    }

    public final boolean aXB(String str) {
        kotlin.g.b.p.h(str, "url");
        if (com.tencent.mm.platformtools.ac.jOz) {
            Log.w(fZo(), "skipLoadUrlCheck");
            return true;
        } else if (this.IKM.IKT) {
            Log.i(fZo(), "albie: trust this url(%s)", str);
            return true;
        } else if (!com.tencent.luggage.h.c.a(str, "file://", true)) {
            return true;
        } else {
            Iterator<T> it = fZq().iterator();
            while (it.hasNext()) {
                if (com.tencent.luggage.h.c.a(str, it.next(), true)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean aXC(String str) {
        kotlin.g.b.p.h(str, "url");
        if (aXB(str)) {
            return false;
        }
        Log.f(fZo(), "forceQuitOnUrlForbidden, canLoadUrl fail, url = ".concat(String.valueOf(str)));
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().gad();
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "run", "com/tencent/mm/plugin/webview/core/BaseWebViewController$intercept$1$1"})
    public static final class aa implements Runnable {
        final /* synthetic */ BaseWebViewController IKR;
        final /* synthetic */ WebResourceRequest ILj;

        aa(WebResourceRequest webResourceRequest, BaseWebViewController baseWebViewController) {
            this.ILj = webResourceRequest;
            this.IKR = baseWebViewController;
        }

        public final void run() {
            AppMethodBeat.i(225006);
            Log.i(this.IKR.fZo(), "shouldInterceptRequest, url = " + this.ILj.getUrl() + ", method = " + this.ILj.getMethod() + ", isForMainFrame = " + this.ILj.isForMainFrame());
            AppMethodBeat.o(225006);
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest, Bundle bundle) {
        String uri;
        kotlin.g.b.p.h(webView, "webView");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        com.tencent.f.h.RTc.aX(new aa(webResourceRequest, this));
        String uri2 = webResourceRequest.getUrl().toString();
        kotlin.g.b.p.g(uri2, "request.url.toString()");
        if (aXC(uri2)) {
            return null;
        }
        if (com.tencent.mm.cr.d.kS(getContext()) && bundle != null) {
            try {
                int i2 = bundle.getInt("resourceType");
                if (i2 == 1 || i2 == 7) {
                    Log.i(fZo(), "get resoutce type is iframe : %d, start geta8key", Integer.valueOf(i2));
                    String uri3 = webResourceRequest.getUrl().toString();
                    kotlin.g.b.p.g(uri3, "request.url.toString()");
                    k(uri3, false, 5);
                }
            } catch (Exception e2) {
                Log.w(fZo(), "get resource type failed Exception ; " + e2.getMessage());
            } catch (Throwable th) {
                Log.w(fZo(), "get resource type failed Throwable ; " + th.getMessage());
            }
        }
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            WebResourceResponse b2 = it.next().b(webView, webResourceRequest);
            if (b2 != null) {
                return b2;
            }
        }
        if (((Boolean) this.IKK.getValue()).booleanValue()) {
            String[] strArr = IKP;
            int i3 = 0;
            for (String str : strArr) {
                int i4 = i3 + 1;
                Uri url = webResourceRequest.getUrl();
                if (!(url == null || (uri = url.toString()) == null || !kotlin.n.n.J(uri, str, false))) {
                    Log.i(fZo(), "QuickAppInterceptor interceptor url = ".concat(String.valueOf(str)));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(TPAudioFrame.TP_CH_LAYOUT_5POINT1, (long) (i3 + 1), 1);
                    if (((Boolean) this.IKL.getValue()).booleanValue()) {
                        Log.i(fZo(), "QuickAppInterceptor interceptor WebResourceResponse");
                        return new WebResourceResponse("", null, null);
                    }
                }
                i3 = i4;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final k.a l(WebView webView, String str) {
        kotlin.g.b.p.h(webView, "webView");
        kotlin.g.b.p.h(str, "url");
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            k.a o2 = it.next().o(webView, str);
            if (o2.INa) {
                return o2;
            }
        }
        return new k.a(false, false);
    }

    /* access modifiers changed from: protected */
    public boolean m(WebView webView, String str) {
        kotlin.g.b.p.h(webView, "webView");
        kotlin.g.b.p.h(str, "url");
        k.a l2 = l(webView, str);
        if (l2.INa) {
            return l2.result;
        }
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, hxF = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
    @kotlin.d.b.a.f(c = "com.tencent.mm.plugin.webview.core.BaseWebViewController$start$1", f = "BaseWebViewController.kt", hxM = {}, m = "invokeSuspend")
    static final class ak extends kotlin.d.b.a.j implements kotlin.g.a.m<kotlinx.coroutines.ai, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ BaseWebViewController IKR;
        int label;
        private kotlinx.coroutines.ai p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ak(BaseWebViewController baseWebViewController, kotlin.d.d dVar) {
            super(2, dVar);
            this.IKR = baseWebViewController;
        }

        @Override // kotlin.d.b.a.a
        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            AppMethodBeat.i(225021);
            kotlin.g.b.p.h(dVar, "completion");
            ak akVar = new ak(this.IKR, dVar);
            akVar.p$ = (kotlinx.coroutines.ai) obj;
            AppMethodBeat.o(225021);
            return akVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final Object invoke(kotlinx.coroutines.ai aiVar, kotlin.d.d<? super kotlin.x> dVar) {
            AppMethodBeat.i(225022);
            Object invokeSuspend = ((ak) create(aiVar, dVar)).invokeSuspend(kotlin.x.SXb);
            AppMethodBeat.o(225022);
            return invokeSuspend;
        }

        @Override // kotlin.d.b.a.a
        public final Object invokeSuspend(Object obj) {
            AppMethodBeat.i(225020);
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    this.IKR.afH(this.IKR.IKk);
                    kotlin.x xVar = kotlin.x.SXb;
                    AppMethodBeat.o(225020);
                    return xVar;
                default:
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(225020);
                    throw illegalStateException;
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, String str, bhj bhj) {
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(bhj, "resp");
        Iterator<T> it = this.ICu.iterator();
        while (it.hasNext()) {
            if (it.next().a(i2, str, bhj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void ePr() {
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public final void C(int i2, String str, String str2) {
        if (str2 != null) {
            com.tencent.xweb.z settings = this.pGj.getSettings();
            if (settings != null) {
                settings.setJavaScriptEnabled(false);
            }
            this.pGj.loadData(str2, "text/html", ProtocolPackage.ServerEncoding);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(224953);
            String str = "MicroMsg.BaseWebViewController:" + this.IKR.fZu();
            AppMethodBeat.o(224953);
            return str;
        }
    }

    public boolean b(int i2, String str, bhj bhj) {
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(bhj, "response");
        Log.i(fZo(), "edw geta8key onSceneEnd, req reason = ".concat(String.valueOf(i2)));
        this.pGj.setA8keyReason(i2);
        Map<String, String> map = this.IJX;
        map.clear();
        LinkedList<ccc> linkedList = bhj.LRq;
        kotlin.g.b.p.g(linkedList, "response.HttpHeader");
        if (!linkedList.isEmpty()) {
            Map<String, String> ij = com.tencent.mm.plugin.webview.f.c.ij(bhj.LRq);
            kotlin.g.b.p.g(ij, "LuggageGetA8Key.getHttpH…ders(response.HttpHeader)");
            map.putAll(ij);
        } else {
            Intent intent2 = this.intent;
            if (intent2 == null) {
                kotlin.g.b.p.btv("intent");
            }
            if (intent2.getBooleanExtra("k_has_http_header", false)) {
                Log.i(fZo(), "use intent httpheader info");
                Intent intent3 = this.intent;
                if (intent3 == null) {
                    kotlin.g.b.p.btv("intent");
                }
                String[] stringArrayExtra = intent3.getStringArrayExtra("geta8key_result_http_header_key_list");
                Intent intent4 = this.intent;
                if (intent4 == null) {
                    kotlin.g.b.p.btv("intent");
                }
                String[] stringArrayExtra2 = intent4.getStringArrayExtra("geta8key_result_http_header_value_list");
                Intent intent5 = this.intent;
                if (intent5 == null) {
                    kotlin.g.b.p.btv("intent");
                }
                intent5.putExtra("k_has_http_header", false);
                Intent intent6 = this.intent;
                if (intent6 == null) {
                    kotlin.g.b.p.btv("intent");
                }
                intent6.putStringArrayListExtra("geta8key_result_http_header_key_list", null);
                Intent intent7 = this.intent;
                if (intent7 == null) {
                    kotlin.g.b.p.btv("intent");
                }
                intent7.putStringArrayListExtra("geta8key_result_http_header_value_list", null);
                if (!(stringArrayExtra == null || stringArrayExtra2 == null)) {
                    if (!(stringArrayExtra.length == 0)) {
                        if ((!(stringArrayExtra2.length == 0)) && stringArrayExtra.length == stringArrayExtra2.length) {
                            int length = stringArrayExtra.length;
                            for (int i3 = 0; i3 < length; i3++) {
                                String str2 = stringArrayExtra[i3];
                                kotlin.g.b.p.g(str2, "httpHeaderKey[i]");
                                String str3 = stringArrayExtra2[i3];
                                kotlin.g.b.p.g(str3, "httpHeaderValue[i]");
                                map.put(str2, str3);
                            }
                        }
                    }
                }
            }
        }
        if (a(i2, str, bhj)) {
            return true;
        }
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().b(str, bhj);
        }
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/UIThreadAuthCallBack;", "Lcom/tencent/mm/protocal/protobuf/GetA8KeyResp;", "invoke"})
    static final class r extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.f<bhj>> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.f.f<bhj> invoke() {
            AppMethodBeat.i(224991);
            com.tencent.mm.plugin.webview.f.f fVar = new com.tencent.mm.plugin.webview.f.f(this.IKR);
            AppMethodBeat.o(224991);
            return fVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/permission/LuggageGetA8Key;", "invoke"})
    static final class g extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.f.c> {
        public static final g ILd = new g();

        static {
            AppMethodBeat.i(224978);
            AppMethodBeat.o(224978);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.f.c invoke() {
            AppMethodBeat.i(224977);
            com.tencent.mm.plugin.webview.f.c cVar = new com.tencent.mm.plugin.webview.f.c();
            AppMethodBeat.o(224977);
            return cVar;
        }
    }

    public void a(int i2, String str, String str2, bhj bhj) {
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "fullUrl");
        kotlin.g.b.p.h(bhj, "response");
        Log.d(fZo(), "WebView-Trace onPermissionUpdate:" + str + ", fullUrl:" + str2);
        if (fZD()) {
            Log.d(fZo(), "onPermissionUpdate destroyCalled");
            return;
        }
        this.mHi.a(str, fZr().aZE(str), fZr().aZF(str));
        this.mHi.a(str2, fZr().aZE(str2), fZr().aZF(str2));
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().c(str, bhj);
        }
        cR(this.IKn, str);
        cR(this.IKn, str2);
        if (kotlin.g.b.p.j(str, this.IJQ)) {
            cR(this.IKu, str);
            Log.i(fZo(), "WebAction:Ready onPermissionUpdated Patch: " + this.IJQ);
        }
    }

    @Override // com.tencent.mm.plugin.webview.f.a
    public void a(int i2, String str, int i3, int i4, String str2) {
        kotlin.g.b.p.h(str, "reqUrl");
        kotlin.g.b.p.h(str2, "errMsg");
        switch (i2) {
            case -1:
            case 0:
                this.IJM = null;
                break;
        }
        cR(this.IKo, str);
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().d(i2, str, i3, str2);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsLoader;", "invoke"})
    static final class ab extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.k> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ab(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.d.k invoke() {
            AppMethodBeat.i(225007);
            com.tencent.mm.plugin.webview.d.k kVar = new com.tencent.mm.plugin.webview.d.k(this.IKR.pGj, this.IKR.getJsapi(), null, this.IKR.pGj.gZa());
            AppMethodBeat.o(225007);
            return kVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "invoke"})
    static final class ac extends kotlin.g.b.q implements kotlin.g.a.a<com.tencent.mm.plugin.webview.d.h> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ac(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ com.tencent.mm.plugin.webview.d.h invoke() {
            com.tencent.mm.plugin.webview.d.h hVar;
            AppMethodBeat.i(225008);
            if (this.IKR.IKN == null) {
                hVar = new com.tencent.mm.plugin.webview.d.h(this.IKR.pGj, this.IKR.mHi, this.IKR.fZu(), this.IKR.IKO);
            } else {
                hVar = new com.tencent.mm.plugin.webview.d.h(this.IKR.pGj, this.IKR.mHi, this.IKR.fZu(), this.IKR.IKN);
            }
            this.IKR.pGj.addJavascriptInterface(hVar, "__wx");
            if (hVar.gbi() != null) {
                this.IKR.pGj.addJavascriptInterface(hVar.gbi(), "__wxtag");
            }
            this.IKR.pGj.addJavascriptInterface(hVar.gaW(), "CustomFullscreenApi");
            this.IKR.pGj.setRandomStr(hVar.gaV());
            AppMethodBeat.o(225008);
            return hVar;
        }
    }

    /* access modifiers changed from: protected */
    public void cpR() {
        if (!this.IKI) {
            fZG();
            this.IKI = true;
        }
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().cpR();
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/webview/core/BaseWebViewController$tryBindService$1", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnectionBinder;", "onConnected", "", "conn", "Lcom/tencent/mm/plugin/webview/core/IWebViewUIConnection;", "onDisconnected", "", "webview-sdk_release"})
    public static final class al implements d {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        al(BaseWebViewController baseWebViewController) {
            this.IKR = baseWebViewController;
        }

        @Override // com.tencent.mm.plugin.webview.core.d
        public final void a(c cVar) {
            AppMethodBeat.i(225023);
            kotlin.g.b.p.h(cVar, "conn");
            if (this.IKR.fZD()) {
                Log.i(this.IKR.fZo(), "WebView-Trace onConnected whent destroyCalled");
                AppMethodBeat.o(225023);
                return;
            }
            this.IKR.IKG = cVar;
            BaseWebViewController baseWebViewController = this.IKR;
            com.tencent.mm.plugin.webview.stub.e fZs = cVar.fZs();
            kotlin.g.b.p.h(fZs, "<set-?>");
            baseWebViewController.mHh = fZs;
            this.IKR.getJsapi().b(this.IKR.fZs());
            this.IKR.a(this.IKR.fZs());
            Log.i(this.IKR.fZo(), "WebView-Trace tryBindService checkStatus CONTROLLER_INVOKER_READY");
            if (this.IKR.IKE.contains(kotlin.g.b.aa.bp(Bind.class).getSimpleName())) {
                this.IKR.ePr();
                AppMethodBeat.o(225023);
                return;
            }
            this.IKR.afH(this.IKR.IKj);
            AppMethodBeat.o(225023);
        }

        @Override // com.tencent.mm.plugin.webview.core.d
        public final boolean fXa() {
            AppMethodBeat.i(225024);
            boolean fZB = this.IKR.fZB();
            AppMethodBeat.o(225024);
            return fZB;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class s extends kotlin.g.b.q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(224992);
            Integer valueOf = Integer.valueOf(this.IKR.hashCode());
            AppMethodBeat.o(224992);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "invoke"})
    static final class y extends kotlin.g.b.q implements kotlin.g.a.a<MMHandler> {
        public static final y ILh = new y();

        static {
            AppMethodBeat.i(225002);
            AppMethodBeat.o(225002);
        }

        y() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMHandler invoke() {
            AppMethodBeat.i(225001);
            MMHandler mMHandler = new MMHandler(Looper.getMainLooper());
            AppMethodBeat.o(225001);
            return mMHandler;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Ljava/lang/Runnable;", "invoke"})
    static final class ai extends kotlin.g.b.q implements kotlin.g.a.a<Runnable> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        ai(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Runnable invoke() {
            AppMethodBeat.i(225018);
            AnonymousClass1 r0 = new Runnable(this) {
                /* class com.tencent.mm.plugin.webview.core.BaseWebViewController.ai.AnonymousClass1 */
                final /* synthetic */ ai ILm;

                {
                    this.ILm = r1;
                }

                public final void run() {
                    AppMethodBeat.i(225017);
                    this.ILm.IKR.cR(this.ILm.IKR.IKr, "");
                    AppMethodBeat.o(225017);
                }
            };
            AppMethodBeat.o(225018);
            return r0;
        }
    }

    public void a(com.tencent.mm.plugin.webview.stub.e eVar) {
    }

    public boolean fZB() {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        r2 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0045, code lost:
        r3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004a, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        r2 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDestroy() {
        /*
            r4 = this;
            r3 = 0
            r0 = 1
            r4.IJS = r0
            boolean r0 = r4.IJT
            if (r0 != 0) goto L_0x000c
            r0 = 0
            r4.yR(r0)
        L_0x000c:
            com.tencent.mm.plugin.webview.core.c r0 = r4.IKG
            if (r0 == 0) goto L_0x0021
            java.io.Closeable r0 = (java.io.Closeable) r0
            java.lang.String r1 = r4.fZo()     // Catch:{ Throwable -> 0x0042, all -> 0x004a }
            java.lang.String r2 = "unbindService"
            com.tencent.mm.sdk.platformtools.Log.i(r1, r2)     // Catch:{ Throwable -> 0x0042, all -> 0x004a }
            kotlin.x r1 = kotlin.x.SXb     // Catch:{ Throwable -> 0x0042, all -> 0x004a }
            kotlin.f.b.a(r0, r3)
        L_0x0021:
            com.tencent.mm.sdk.platformtools.MMHandler r0 = r4.bkj()
            java.lang.Runnable r1 = r4.fZv()
            r0.removeCallbacksAndMessages(r1)
            com.tencent.mm.plugin.webview.d.h r0 = r4.getJsapi()
            r0.detach()
            com.tencent.mm.plugin.webview.d.k r0 = r4.fZt()
            r0.detach()
            com.tencent.mm.plugin.webview.f.c r0 = r4.fZr()
            r0.destroy()
            return
        L_0x0042:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r2 = move-exception
            r3 = r1
        L_0x0046:
            kotlin.f.b.a(r0, r3)
            throw r2
        L_0x004a:
            r1 = move-exception
            r2 = r1
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.core.BaseWebViewController.onDestroy():void");
    }

    public void fZC() {
        this.IJT = false;
    }

    public final boolean fZD() {
        return this.IJT || this.IJS;
    }

    public final void yR(boolean z2) {
        try {
            com.tencent.mm.plugin.webview.stub.e eVar = this.mHh;
            if (eVar == null) {
                kotlin.g.b.p.btv("invoker");
            }
            if (eVar != null) {
                if (!z2) {
                    com.tencent.mm.plugin.webview.stub.e eVar2 = this.mHh;
                    if (eVar2 == null) {
                        kotlin.g.b.p.btv("invoker");
                    }
                    eVar2.agy(fZu());
                }
                com.tencent.mm.plugin.webview.stub.e eVar3 = this.mHh;
                if (eVar3 == null) {
                    kotlin.g.b.p.btv("invoker");
                }
                eVar3.bs(fZu(), z2);
            }
            Log.i(fZo(), "removeInvoker ok");
        } catch (Exception e2) {
            Log.w(fZo(), "onDestroy, remove callback and invoke event on webview destroy, ex = ".concat(String.valueOf(e2)));
        }
    }

    public final void reload() {
        if (this.pGj != null && !Util.isNullOrNil(this.pGj.getUrl())) {
            Iterator<T> it = this.ICu.iterator();
            while (it.hasNext()) {
                String url = this.pGj.getUrl();
                kotlin.g.b.p.g(url, "viewWV.url");
                if (it.next().aiD(Yc(url))) {
                    return;
                }
            }
            Log.i(fZo(), "reload");
            this.pGj.reload();
        }
    }

    public final void destroy() {
        com.tencent.mm.ac.d.h(new w(this));
    }

    @Override // com.tencent.xweb.ac
    public final void e(WebView webView, String str) {
        String str2;
        com.tencent.mm.plugin.webview.d.h jsapi;
        if (fZD()) {
            Log.w(fZo(), "ActivityFinished");
            return;
        }
        com.tencent.mm.plugin.webview.d.h jsapi2 = getJsapi();
        if (jsapi2 != null) {
            jsapi2.fWV();
        }
        if (fZE() && !this.pGj.gZa() && !afI(this.IKl) && str != null && !kotlin.n.n.J(str, "file:", false) && (jsapi = getJsapi()) != null) {
            jsapi.gaU();
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        String Yc = Yc(str2);
        Log.i(fZo(), "WebView-Trace onPageCommitVisible: " + str + ", callbackUrl:" + Yc);
        aXy(Yc);
        super.e(webView, str);
        g.a aVar = g.ILB;
        if (!g.a.fZQ()) {
            cR(this.IKs, aXw(str));
        } else {
            Log.i(fZo(), "WebView Page Commit Mock Enabled");
        }
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.e(webView, Yc);
            }
        }
        n(webView, str);
    }

    @Override // com.tencent.xweb.ac
    public void b(WebView webView, String str) {
        String str2;
        if (fZD()) {
            Log.w(fZo(), "ActivityFinished");
            return;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        String Yc = Yc(str2);
        Log.i(fZo(), "WebView-Trace onPageFinished: " + str + ", callbackUrl:" + Yc);
        super.b(webView, str);
        if (!this.IKB.contains(Integer.valueOf(this.IKs)) && !cph()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(1200, 104, 1, false);
            Log.i(fZo(), "WebView-Trace onPageFinished callback before onPageCommitVisible");
        }
        cR(this.IKt, aXw(str));
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.b(webView, Yc);
            }
        }
        n(webView, str);
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, int i2, String str, String str2) {
        super.a(webView, i2, str, str2);
        if (!afI(this.IKk)) {
            Log.i(fZo(), "onReceivedError, intent not ready");
            return;
        }
        Log.i(fZo(), "WebView-Trace onReceivedError, errCode:" + i2 + ", description:" + str + ", failingUrl:" + str2);
        if (afI(this.IKj)) {
            e fZw = fZw();
            if (fZw.bVc() && str2 != null) {
                com.tencent.f.h.RTc.b(new e.c(fZw, str2, i2, str), "MicroMsg.WebPageErrorMonitor");
            }
        }
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.a(webView, i2, str, str2);
            }
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class v extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(224997);
            String stringExtra = this.IKR.getIntent().getStringExtra("data");
            AppMethodBeat.o(224997);
            return stringExtra;
        }
    }

    @Override // com.tencent.xweb.ac
    public final void a(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Uri uri = null;
        super.a(webView, webResourceRequest, webResourceResponse);
        if (!afI(this.IKk)) {
            Log.i(fZo(), "onReceivedHttpError, intent not ready");
            return;
        }
        String fZo = fZo();
        StringBuilder append = new StringBuilder("WebView-Trace onReceivedHttpError, errCode:").append(webResourceResponse != null ? Integer.valueOf(webResourceResponse.getStatusCode()) : null).append(", description:").append(webResourceResponse != null ? webResourceResponse.getReasonPhrase() : null).append(", failingUrl:");
        if (webResourceRequest != null) {
            uri = webResourceRequest.getUrl();
        }
        Log.i(fZo, append.append(String.valueOf(uri)).toString());
        if (afI(this.IKj)) {
            e fZw = fZw();
            if (fZw.bVc() && webResourceRequest != null) {
                com.tencent.f.h.RTc.b(new e.d(fZw, webResourceRequest, webResourceResponse), "MicroMsg.WebPageErrorMonitor");
            }
        }
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.a(webView, webResourceRequest, webResourceResponse);
            }
        }
    }

    @Override // com.tencent.xweb.ac
    public void a(WebView webView, com.tencent.xweb.r rVar, SslError sslError) {
        super.a(webView, rVar, sslError);
        if (!afI(this.IKk)) {
            Log.i(fZo(), "onReceivedSslError, intent not ready");
            return;
        }
        Log.i(fZo(), "WebView-Trace onReceivedSslError, " + (sslError != null ? sslError.toString() : null));
        if (afI(this.IKj)) {
            e fZw = fZw();
            if (fZw.bVc() && sslError != null) {
                com.tencent.f.h.RTc.b(new e.RunnableC1945e(fZw, sslError), "MicroMsg.WebPageErrorMonitor");
            }
        }
        for (T t2 : this.IKc) {
            if (isStarted()) {
                t2.a(webView, rVar, sslError);
            }
        }
    }

    @Override // com.tencent.xweb.ac
    public void b(WebView webView, String str, boolean z2) {
        kotlin.g.b.p.h(webView, "view");
        kotlin.g.b.p.h(str, "url");
        Log.i(fZo(), "WebView-Trace doUpdateVisitedHistory, url = " + str + ", wvUrl = " + webView.getUrl() + ", isReload = " + z2);
        if (kotlin.n.n.J(str, "data:text/html;charset=utf-8", false)) {
            Log.i(fZo(), "url starts with data:text, url : ".concat(String.valueOf(str)));
        } else if (com.tencent.luggage.h.c.A(str, "about:blank") || com.tencent.luggage.h.c.A(str, "file:///android_asset/")) {
            Log.e(fZo(), "doUpdateVisitedHistory, url is invalid");
        } else {
            if (afI(this.IKl)) {
                String str2 = com.tencent.mm.plugin.webview.h.a.pFm;
                kotlin.g.b.p.g(str2, "ConstantsPreload.HARDCODE_URL");
                if (com.tencent.luggage.h.c.A(str, str2)) {
                    Log.i(fZo(), "doUpdateVisitedHistory, url is HARDCODE_URL");
                    return;
                }
            }
            super.b(webView, str, z2);
            if (((Boolean) this.IKJ.getValue()).booleanValue()) {
                str = webView.getUrl();
            }
            kotlin.g.b.p.g(str, "url");
            if (!kotlin.g.b.p.j(this.IJO, str)) {
                if (this.mHi.has(str)) {
                    cR(this.IKu, str);
                }
                fZt().gbk();
                this.IJQ = str;
            }
            if (!this.IKM.IKW) {
                k(str, false, fZr().cO(str, true));
            }
            this.IJM = str;
            for (T t2 : this.IKc) {
                if (isStarted()) {
                    t2.aXF(str);
                }
            }
            n(webView, str);
        }
    }

    private final void n(WebView webView, String str) {
        if (webView != null && this.IKf && webView.canGoBack()) {
            Log.i(fZo(), "clearHistory :".concat(String.valueOf(str)));
            webView.clearHistory();
            this.IKf = false;
        }
    }

    public final boolean fZF() {
        boolean afJ;
        synchronized (this) {
            afJ(this.IKm);
            afJ = afJ(this.IKl);
        }
        return afJ;
    }

    /* access modifiers changed from: protected */
    public void fZG() {
    }

    public final void n(String str, kotlin.g.a.b<? super String, kotlin.x> bVar) {
        kotlin.g.b.p.h(str, "script");
        com.tencent.mm.ac.d.h(new x(this, str, bVar));
    }

    public final String beU() {
        return fZr().aZj(getCurrentUrl());
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final String Yc(String str) {
        String str2;
        if (!aix(str)) {
            str2 = this.IJP;
        } else {
            str2 = str;
        }
        if (!kotlin.n.n.aL(str2) || !afI(this.IKk)) {
            return str2;
        }
        return coX();
    }

    public boolean cph() {
        return afI(this.IKl) && kotlin.g.b.p.j(this.djt, this.IJP);
    }

    /* access modifiers changed from: protected */
    public final void onFinish() {
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().onFinish();
        }
    }

    /* access modifiers changed from: protected */
    public final void yS(boolean z2) {
        Iterator<T> it = this.IKd.iterator();
        while (it.hasNext()) {
            it.next().yS(z2);
        }
    }

    /* access modifiers changed from: protected */
    public void fZH() {
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224982);
            Log.i(this.IKR.fZo(), "WebView-Trace inject");
            this.IKR.fZt().gbl();
            this.IKR.getJsapi().gbj();
            if (BuildInfo.DEBUG) {
                this.IKR.n((BaseWebViewController) ("console.log('inject:'+" + this.IKR.fZu() + ')'), (String) null);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224982);
            return xVar;
        }
    }

    /* access modifiers changed from: protected */
    public final int getScreenOrientation() {
        for (T t2 : this.ICu) {
            if (t2.getScreenOrientation() != -1) {
                return t2.getScreenOrientation();
            }
        }
        return -1;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224985);
            this.IKR.fZt().aYl(null);
            BaseWebViewController.j(this.IKR);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224985);
            return xVar;
        }
    }

    public final boolean fZI() {
        return !afI(this.IKl);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/webview/core/BaseWebViewController$Companion;", "", "()V", "DATA_TEXT_HTML_PREFIX", "", "FILE_URL_SCHEME", "QuickAppUrl", "", "[Ljava/lang/String;", "getRawUrl", "intent", "Landroid/content/Intent;", "webview-sdk_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }

        public static String bj(Intent intent) {
            String str;
            boolean z;
            String str2;
            AppMethodBeat.i(224955);
            kotlin.g.b.p.h(intent, "intent");
            try {
                String stringExtra = intent.getStringExtra("rawUrl");
                if (stringExtra == null) {
                    stringExtra = "";
                }
                str = stringExtra;
            } catch (Exception e2) {
                Log.e("MicroMsg.WebViewController", "getRawUrl exception:%s", e2.getMessage());
                if (e2 instanceof ClassNotFoundException) {
                    Exception exc = e2;
                    AppMethodBeat.o(224955);
                    throw exc;
                }
                str = null;
            }
            String str3 = str;
            if (str3 == null || kotlin.n.n.aL(str3)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                AppMethodBeat.o(224955);
                return str;
            }
            Uri data = intent.getData();
            if (data == null || (str2 = data.toString()) == null) {
                str2 = "";
            }
            AppMethodBeat.o(224955);
            return str2;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class m extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224986);
            if (!this.IKR.pGj.gZa()) {
                this.IKR.fZt().KY();
            }
            this.IKR.cpR();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224986);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224987);
            if (this.IKR.pGj.gZa()) {
                BaseWebViewController baseWebViewController = this.IKR;
                String url = this.IKR.pGj.getUrl();
                if (url == null) {
                    url = "";
                }
                baseWebViewController.aXx(url);
            }
            if (!this.IKR.fZD()) {
                this.IKR.fZH();
                this.IKR.cpd();
                this.IKR.fZA();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224987);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224988);
            this.IKR.fZt().KY();
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224988);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            boolean z;
            String url;
            boolean z2;
            com.tencent.mm.plugin.webview.d.h jsapi;
            AppMethodBeat.i(224981);
            String str = this.IKR.IJO;
            if (str == null || kotlin.n.n.aL(str)) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                url = this.IKR.IJO;
            } else {
                url = this.IKR.pGj.getUrl();
                if (url == null) {
                    url = "";
                }
            }
            this.IKR.aXy(url);
            com.tencent.mm.plugin.webview.d.h jsapi2 = this.IKR.getJsapi();
            if (jsapi2 != null) {
                jsapi2.fWV();
            }
            if (url.length() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2 && !kotlin.n.n.J(url, "file:", false) && this.IKR.fZE() && !this.IKR.pGj.gZa() && !this.IKR.afI(this.IKR.IKl) && (jsapi = this.IKR.getJsapi()) != null) {
                jsapi.gaU();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224981);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class w extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224998);
            this.IKR.pGj.clearView();
            this.IKR.pGj.destroy();
            try {
                this.IKR.onDestroy();
            } catch (Exception e2) {
                Log.e(this.IKR.fZo(), "destroy ex:".concat(String.valueOf(e2)));
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224998);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class am extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final am ILn = new am();

        static {
            AppMethodBeat.i(225026);
            AppMethodBeat.o(225026);
        }

        am() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(225025);
            Boolean valueOf = Boolean.valueOf(com.tencent.mm.pluginsdk.ui.tools.z.gsL());
            AppMethodBeat.o(225025);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class an extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final an ILo = new an();

        static {
            AppMethodBeat.i(225028);
            AppMethodBeat.o(225028);
        }

        an() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(225027);
            if (((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_webview_update_history_use_wv_url, 1) == 1) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(225027);
            return valueOf;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class x extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;
        final /* synthetic */ kotlin.g.a.b gWe;
        final /* synthetic */ String pCF;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(BaseWebViewController baseWebViewController, String str, kotlin.g.a.b bVar) {
            super(0);
            this.IKR = baseWebViewController;
            this.pCF = str;
            this.gWe = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AnonymousClass1 r0;
            AppMethodBeat.i(225000);
            MMWebView mMWebView = this.IKR.pGj;
            String str = this.pCF;
            if (this.gWe != null) {
                r0 = new ValueCallback<String>(this) {
                    /* class com.tencent.mm.plugin.webview.core.BaseWebViewController.x.AnonymousClass1 */
                    final /* synthetic */ x ILg;

                    {
                        this.ILg = r1;
                    }

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // android.webkit.ValueCallback
                    public final /* synthetic */ void onReceiveValue(String str) {
                        AppMethodBeat.i(224999);
                        String str2 = str;
                        kotlin.g.a.b bVar = this.ILg.gWe;
                        kotlin.g.b.p.g(str2, LocaleUtil.ITALIAN);
                        bVar.invoke(str2);
                        AppMethodBeat.o(224999);
                    }
                };
            } else {
                r0 = null;
            }
            mMWebView.evaluateJavascript(str, r0);
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(225000);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224989);
            Iterator<T> it = this.IKR.IKd.iterator();
            while (it.hasNext()) {
                it.next().gae();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224989);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class q extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        final /* synthetic */ BaseWebViewController IKR;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(BaseWebViewController baseWebViewController) {
            super(0);
            this.IKR = baseWebViewController;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(224990);
            Iterator<T> it = this.IKR.IKd.iterator();
            while (it.hasNext()) {
                it.next().gaf();
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(224990);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class ag extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final ag ILl = new ag();

        static {
            AppMethodBeat.i(225014);
            AppMethodBeat.o(225014);
        }

        ag() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(225013);
            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_webview_quickapp_interceptor, 0) & 1) != 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(225013);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class af extends kotlin.g.b.q implements kotlin.g.a.a<Boolean> {
        public static final af ILk = new af();

        static {
            AppMethodBeat.i(225012);
            AppMethodBeat.o(225012);
        }

        af() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            boolean z;
            AppMethodBeat.i(225011);
            if ((((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_open_webview_quickapp_interceptor, 0) & 2) != 0) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(225011);
            return valueOf;
        }
    }

    @Override // com.tencent.xweb.ac
    public final WebResourceResponse a(WebView webView, WebResourceRequest webResourceRequest) {
        kotlin.g.b.p.h(webView, "webview");
        kotlin.g.b.p.h(webResourceRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        WebResourceResponse b2 = b(webView, webResourceRequest, (Bundle) null);
        return b2 == null ? super.a(webView, webResourceRequest) : b2;
    }

    public static final /* synthetic */ void j(BaseWebViewController baseWebViewController) {
        Iterator<T> it = baseWebViewController.IKd.iterator();
        while (it.hasNext()) {
            it.next().gab();
        }
    }
}
