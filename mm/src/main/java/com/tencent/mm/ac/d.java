package com.tencent.mm.ac;

import android.content.Intent;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.widget.TextView;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.f.h;
import com.tencent.f.i.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¦\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a>\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\b¢\u0006\u0002\u0010\n\u001a\"\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\tH\b¢\u0006\u0002\u0010\u000e\u001a*\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\tH\b¢\u0006\u0002\u0010\u000f\u001a\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013\u001a\"\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\t\"\u0004\b\u0000\u0010\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0016\u001a\"\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0019\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\t\u001a,\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\t\u001a\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 \u001a\u0006\u0010!\u001a\u00020\u0003\u001a\u001f\u0010\"\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u00012\u000e\b\u0004\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00010\tH\b\u001a\u000e\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0005\u001a^\u0010%\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010&*\u00020'\"\b\b\u0001\u0010(*\u00020'\"\b\b\u0002\u0010\f*\u00020'2\b\u0010)\u001a\u0004\u0018\u0001H&2\b\u0010*\u001a\u0004\u0018\u0001H(2\u001a\u0010\r\u001a\u0016\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0006\u0012\u0004\u0018\u0001H\f0+H\b¢\u0006\u0002\u0010,\u001ax\u0010%\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010&*\u00020'\"\b\b\u0001\u0010(*\u00020'\"\b\b\u0002\u0010-*\u00020'\"\b\b\u0003\u0010\f*\u00020'2\b\u0010)\u001a\u0004\u0018\u0001H&2\b\u0010*\u001a\u0004\u0018\u0001H(2\b\u0010.\u001a\u0004\u0018\u0001H-2 \u0010\r\u001a\u001c\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H-\u0012\u0006\u0012\u0004\u0018\u0001H\f0/H\b¢\u0006\u0002\u00100\u001a\u0001\u0010%\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010&*\u00020'\"\b\b\u0001\u0010(*\u00020'\"\b\b\u0002\u0010-*\u00020'\"\b\b\u0003\u00101*\u00020'\"\b\b\u0004\u0010\f*\u00020'2\b\u0010)\u001a\u0004\u0018\u0001H&2\b\u0010*\u001a\u0004\u0018\u0001H(2\b\u0010.\u001a\u0004\u0018\u0001H-2\b\u00102\u001a\u0004\u0018\u0001H12&\u0010\r\u001a\"\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H1\u0012\u0006\u0012\u0004\u0018\u0001H\f03H\b¢\u0006\u0002\u00104\u001a¬\u0001\u0010%\u001a\u0004\u0018\u0001H\f\"\b\b\u0000\u0010&*\u00020'\"\b\b\u0001\u0010(*\u00020'\"\b\b\u0002\u0010-*\u00020'\"\b\b\u0003\u00101*\u00020'\"\b\b\u0004\u00105*\u00020'\"\b\b\u0005\u0010\f*\u00020'2\b\u0010)\u001a\u0004\u0018\u0001H&2\b\u0010*\u001a\u0004\u0018\u0001H(2\b\u0010.\u001a\u0004\u0018\u0001H-2\b\u00102\u001a\u0004\u0018\u0001H12\b\u00106\u001a\u0004\u0018\u0001H52,\u0010\r\u001a(\u0012\u0004\u0012\u0002H&\u0012\u0004\u0012\u0002H(\u0012\u0004\u0012\u0002H-\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H5\u0012\u0006\u0012\u0004\u0018\u0001H\f07H\b¢\u0006\u0002\u00108\u001a\u0016\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:\u001a\u0016\u0010=\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:\u001a\u0016\u0010>\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:\u001a\u0014\u0010?\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a\u000e\u0010?\u001a\u00020\u00112\u0006\u0010@\u001a\u00020A\u001a\"\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\t\"\u0004\b\u0000\u0010\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0016\u001a\f\u0010C\u001a\b\u0012\u0004\u0012\u00020E0D\u001a&\u0010F\u001a\u00020\u00112\u0006\u0010G\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a \u0010F\u001a\u00020\u00112\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a\u001c\u0010I\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a&\u0010I\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a0\u0010J\u001a\u00020\u00112\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010H\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t2\b\b\u0002\u0010K\u001a\u00020\u0005\u001a\u0012\u0010L\u001a\u0004\u0018\u00010\u001e2\b\u0010M\u001a\u0004\u0018\u00010\u001e\u001a\u0014\u0010N\u001a\u00020\u00112\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a\u000e\u0010N\u001a\u00020\u00112\u0006\u0010@\u001a\u00020A\u001a\u001c\u0010N\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00110\t\u001a\u0016\u0010N\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00052\u0006\u0010@\u001a\u00020A\u001a\u0010\u0010O\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u0003\u001a&\u0010P\u001a\u00020\u0011*\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020\u0007\u001a&\u0010P\u001a\u00020\u0011*\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020\u0007\u001a&\u0010W\u001a\u00020\u0011*\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020:\u001a&\u0010W\u001a\u00020\u0011*\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010S\u001a\u00020\u00032\b\b\u0002\u0010T\u001a\u00020:\u001a\u001c\u0010X\u001a\u00020\u0011*\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010S\u001a\u00020\u0003\u001a\u001c\u0010Y\u001a\u00020\u0011*\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010Q2\u0006\u0010S\u001a\u00020\u0003\u001a\u001c\u0010Y\u001a\u00020\u0011*\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010S\u001a\u00020\u0003\u001aT\u0010Z\u001a\b\u0012\u0004\u0012\u0002H\u00010[\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010[26\u0010\\\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(^\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00070+\u001aT\u0010`\u001a\b\u0012\u0004\u0012\u0002H\u00010[\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010[26\u0010\\\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(^\u0012\u0013\u0012\u0011H\u0001¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(_\u0012\u0004\u0012\u00020\u00110+\u001a\n\u0010a\u001a\u00020b*\u00020c\u001a\n\u0010d\u001a\u00020b*\u00020c\u001a\u0011\u0010e\u001a\u0004\u0018\u00010f*\u0004\u0018\u00010gH\b\u001a\u0017\u0010h\u001a\u00020\u0007*\u0004\u0018\u00010i2\u0006\u0010S\u001a\u00020\u0003H\b\u001a\u001f\u0010j\u001a\u00020:*\u0004\u0018\u00010i2\u0006\u0010S\u001a\u00020\u00032\u0006\u0010k\u001a\u00020:H\b\u001a\u0019\u0010l\u001a\u0004\u0018\u00010\u0003*\u0004\u0018\u00010i2\u0006\u0010S\u001a\u00020\u0003H\b\u001a(\u0010m\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020n*\u0002H\u00012\b\u0010o\u001a\u0004\u0018\u00010fH\b¢\u0006\u0002\u0010p\u001aL\u0010m\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020n*\u0002H\u00012\b\u0010o\u001a\u0004\u0018\u00010f2%\u0010\r\u001a!\u0012\u0017\u0012\u00150rj\u0002`s¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(t\u0012\u0004\u0012\u00020\u00110q¢\u0006\u0002\u0010u\u001a3\u0010v\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0016\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010w2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070qH\b\u001aQ\u0010v\u001a\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u0002H{0y\"\u0004\b\u0000\u0010z\"\u0004\b\u0001\u0010{*\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u0002H{0y2\u001e\u0010x\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u0002H{0|\u0012\u0004\u0012\u00020\u00070qH\b\u001aH\u0010}\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0016\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010w2'\u0010x\u001a#\u0012\u0013\u0012\u00110:¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(~\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070+H\b\u001a5\u0010\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010w2\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070qH\b¢\u0006\u0003\u0010\u0001\u001a/\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010w2\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00110qH\b\u001aG\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010z\"\u0004\b\u0001\u0010{*\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u0002H{0y2\u001f\u0010\u0001\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hz\u0012\u0004\u0012\u0002H{0|\u0012\u0004\u0012\u00020\u00110qH\b\u001aD\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010w2(\u0010\u0001\u001a#\u0012\u0013\u0012\u00110:¢\u0006\f\b]\u0012\b\b\u0019\u0012\u0004\b\b(~\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00110+H\b\u001a.\u0010\u0001\u001a\u00020:\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00162\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070qH\b\u001a6\u0010\u0001\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00162\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070qH\b¢\u0006\u0003\u0010\u0001\u001a,\u0010\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0001*\t\u0012\u0004\u0012\u0002H\u00010\u00012\u0012\u0010x\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00070q\u001aF\u0010\u0001\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\t\u0012\u0004\u0012\u0002H\u00010\u00012$\b\u0002\u0010\\\u001a\u001e\u0012\u0014\u0012\u0012H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070q¢\u0006\u0003\u0010\u0001\u001aK\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\f0D\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010D2&\u0010\\\u001a\"\u0012\u0016\u0012\u0014\u0018\u0001H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\f0q\u001a.\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u0002H\u00010\u0001j\t\u0012\u0004\u0012\u0002H\u0001`\u0001\"\u000b\b\u0000\u0010\u0001\u0018\u0001*\u00030\u0001*\u00030\u0001H\b\u001a#\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002H\u00010\u0001\"\u000b\b\u0000\u0010\u0001\u0018\u0001*\u00030\u0001*\u00030\u0001H\b\u001aK\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H\f0D\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u0002H\u00010D2&\u0010\\\u001a\"\u0012\u0016\u0012\u0014\u0018\u0001H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\f0q\u001aD\u0010\u0001\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\t\u0012\u0004\u0012\u0002H\u00010\u00012\"\u0010\\\u001a\u001e\u0012\u0014\u0012\u0012H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070q¢\u0006\u0003\u0010\u0001\u001a<\u0010\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0001*\t\u0012\u0004\u0012\u0002H\u00010\u00012\"\u0010\\\u001a\u001e\u0012\u0014\u0012\u0012H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070q\u001aG\u0010\u0001\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0001*\u0014\u0012\u0004\u0012\u0002H\u00010\u0001j\t\u0012\u0004\u0012\u0002H\u0001`\u00012\"\u0010\\\u001a\u001e\u0012\u0014\u0012\u0012H\u0001¢\u0006\r\b]\u0012\t\b\u0019\u0012\u0005\b\b(\u0001\u0012\u0004\u0012\u00020\u00070q\u001a\u001d\u0010\u0001\u001a\u00020\u0003*\u00020\u00032\u0007\u0010\u0001\u001a\u00020:2\u0007\u0010\u0001\u001a\u00020:¨\u0006\u0001"}, hxF = {"checkUICost", "T", "tag", "", "thresholdMs", "", "isThrowException", "", "call", "Lkotlin/Function0;", "(Ljava/lang/String;JZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "codeConsume", "R", "block", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "commonShadow", "", "textView", "Landroid/widget/TextView;", "consumeList", "list", "", "createMMHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "name", "createMediaCodecThread", "Landroid/os/HandlerThread;", "isAfterAutoSafeQuit", "drawable2Bitmap", "Landroid/graphics/Bitmap;", "drawable", "Landroid/graphics/drawable/Drawable;", "getCaller", "idle", "long2UnsignedString", "seq", "multiLet", "T1", "", "T2", "p1", "p2", "Lkotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "T3", "p3", "Lkotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "T4", "p4", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "T5", "p5", "Lkotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "opAddFlag", "", "value", "flag", "opCheckFlag", "opCleanFlag", "removeUiRunnable", "task", "Ljava/lang/Runnable;", "reverseConsumeList", "rxPipeLine", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Ljava/lang/Void;", "threadPool", "taskName", "isPrintLog", "threadPoolTag", "threadPoolTagDelayed", "delay", "toBitmap8888", "source", "uiThread", "unsignedString2Long", "copyBooleanExtra", "Landroid/content/Intent;", FacebookRequestErrorClassification.KEY_OTHER, "key", "defaultValue", "bundle", "Landroid/os/Bundle;", "copyIntExtra", "copyStringArrayListExtra", "copyStringExtra", "filter", "Landroid/util/LongSparseArray;", "func", "Lkotlin/ParameterName;", "k", "v", "forEach", "getLocationInWindow", "", "Landroid/view/View;", "getLocationOnScreen", "safeBufferToByte", "", "Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;", "safeGetBoolean", "Lorg/json/JSONObject;", "safeGetInt", BuildConfig.KINDA_DEFAULT, "safeGetString", "safeParser", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "byteArray", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[B)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "(Lcom/tencent/mm/protobuf/BaseProtoBuf;[BLkotlin/jvm/functions/Function1;)Lcom/tencent/mm/protobuf/BaseProtoBuf;", "synchronizedFilter", "", "predicate", "", "K", "V", "", "synchronizedFilterIndexed", FirebaseAnalytics.b.INDEX, "synchronizedFind", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedForEach", NativeProtocol.WEB_DIALOG_ACTION, "synchronizedForEachIndexed", "synchronizedIndexOfFirst", "synchronizedLastOrNull", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "synchronizedRemoveAll", "", "synchronizedRemoveFirstOrNull", "Ljava/util/HashSet;", "t", "(Ljava/util/HashSet;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "thread", "toArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lcom/tencent/mm/sdk/storage/IAutoDBItem;", "Landroid/database/Cursor;", "toLinkedList", "Ljava/util/LinkedList;", "ui", "wxRemoveFirst", "wxRemoveIf", "wxSubString", "start", "end", "libktcomm_release"})
public final class d {
    public static final void h(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(153450);
        p.h(aVar, "block");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (p.j(currentThread, mainLooper.getThread())) {
            aVar.invoke();
            AppMethodBeat.o(153450);
            return;
        }
        MMHandlerThread.postToMainThread(new e(aVar));
        AppMethodBeat.o(153450);
    }

    public static final void B(Runnable runnable) {
        AppMethodBeat.i(204379);
        p.h(runnable, "task");
        Thread currentThread = Thread.currentThread();
        Looper mainLooper = Looper.getMainLooper();
        p.g(mainLooper, "Looper.getMainLooper()");
        if (p.j(currentThread, mainLooper.getThread())) {
            runnable.run();
            AppMethodBeat.o(204379);
            return;
        }
        MMHandlerThread.postToMainThread(runnable);
        AppMethodBeat.o(204379);
    }

    public static final void a(long j2, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(153451);
        p.h(aVar, "block");
        MMHandlerThread.postToMainThreadDelayed(new e(aVar), j2);
        AppMethodBeat.o(153451);
    }

    public static final void a(long j2, Runnable runnable) {
        AppMethodBeat.i(204380);
        p.h(runnable, "task");
        MMHandlerThread.postToMainThreadDelayed(runnable, j2);
        AppMethodBeat.o(204380);
    }

    public static final void C(Runnable runnable) {
        AppMethodBeat.i(204381);
        p.h(runnable, "task");
        MMHandlerThread.removeRunnable(runnable);
        AppMethodBeat.o(204381);
    }

    public static final void i(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(204382);
        p.h(aVar, "block");
        b(getCaller(), aVar);
        AppMethodBeat.o(204382);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/kt/CommonKt$threadPool$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
    /* renamed from: com.tencent.mm.ac.d$d  reason: collision with other inner class name */
    public static final class C0241d implements j {
        final /* synthetic */ String hvo;
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ boolean hvq = true;

        C0241d(String str, kotlin.g.a.a aVar, boolean z) {
            this.hvo = str;
            this.hvp = aVar;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return this.hvo;
        }

        public final void run() {
            AppMethodBeat.i(204375);
            this.hvp.invoke();
            AppMethodBeat.o(204375);
        }

        @Override // com.tencent.f.i.j
        public final boolean axI() {
            return this.hvq;
        }
    }

    public static final void b(String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(204383);
        p.h(str, "taskName");
        p.h(aVar, "block");
        h.RTc.aX(new C0241d(str, aVar, true));
        AppMethodBeat.o(204383);
    }

    public static final void c(String str, kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(204384);
        p.h(str, "tag");
        p.h(aVar, "block");
        p.h(str, "tag");
        p.h(aVar, "block");
        h.RTc.b(new e(str, aVar), str);
        AppMethodBeat.o(204384);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/kt/CommonKt$threadPoolTag$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
    public static final class e implements j {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ boolean hvq = true;
        final /* synthetic */ String hvr;

        e(String str, kotlin.g.a.a aVar) {
            this.hvr = str;
            this.hvp = aVar;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            AppMethodBeat.i(204376);
            String str = this.hvr + "#" + this.hvp.hashCode();
            AppMethodBeat.o(204376);
            return str;
        }

        public final void run() {
            AppMethodBeat.i(204377);
            this.hvp.invoke();
            AppMethodBeat.o(204377);
        }

        @Override // com.tencent.f.i.j
        public final boolean axI() {
            return this.hvq;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/kt/CommonKt$threadPoolTagDelayed$1", "Lcom/tencent/threadpool/runnable/LoggingRunnable;", "getKey", "", "isLogging", "", "run", "", "libktcomm_release"})
    public static final class f implements j {
        final /* synthetic */ kotlin.g.a.a hvp;
        final /* synthetic */ boolean hvq = true;
        final /* synthetic */ String hvr;

        public f(String str, kotlin.g.a.a aVar) {
            this.hvr = str;
            this.hvp = aVar;
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return this.hvr;
        }

        public final void run() {
            AppMethodBeat.i(204378);
            this.hvp.invoke();
            AppMethodBeat.o(204378);
        }

        @Override // com.tencent.f.i.j
        public final boolean axI() {
            return this.hvq;
        }
    }

    private static String getCaller() {
        AppMethodBeat.i(204385);
        try {
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace == null || stackTrace.length < 4) {
                AppMethodBeat.o(204385);
                return "";
            }
            StackTraceElement stackTraceElement = stackTrace[3];
            p.g(stackTraceElement, "stackTrace[3]");
            String className = stackTraceElement.getClassName();
            p.g(className, "stackTrace[3].className");
            if (className == null) {
                t tVar = new t("null cannot be cast to non-null type java.lang.String");
                AppMethodBeat.o(204385);
                throw tVar;
            }
            String substring = className.substring(15);
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            StringBuilder append = new StringBuilder().append(substring).append(":");
            StackTraceElement stackTraceElement2 = stackTrace[3];
            p.g(stackTraceElement2, "stackTrace[3]");
            StringBuilder append2 = new StringBuilder().append(append.append(stackTraceElement2.getMethodName()).toString()).append("[");
            StackTraceElement stackTraceElement3 = stackTrace[3];
            p.g(stackTraceElement3, "stackTrace[3]");
            String sb = append2.append(stackTraceElement3.getLineNumber()).append("]").toString();
            AppMethodBeat.o(204385);
            return sb;
        } catch (Throwable th) {
            AppMethodBeat.o(204385);
            return "";
        }
    }

    public static final <R> HandlerThread a(String str, boolean z, kotlin.g.a.a<? extends R> aVar) {
        AppMethodBeat.i(182804);
        p.h(str, "name");
        p.h(aVar, "block");
        HandlerThread hB = com.tencent.f.c.d.hB(str, 5);
        hB.start();
        new MMHandler(hB.getLooper()).post(new b(hB, aVar, z));
        p.g(hB, "SpecialThreadFactory.cre…        }\n        }\n    }");
        AppMethodBeat.o(182804);
        return hB;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003¨\u0006\u0004"}, hxF = {"<anonymous>", "", "R", "run", "com/tencent/mm/kt/CommonKt$createMediaCodecThread$1$1"})
    static final class b implements Runnable {
        final /* synthetic */ HandlerThread hvk;
        final /* synthetic */ kotlin.g.a.a hvl;
        final /* synthetic */ boolean hvm;

        b(HandlerThread handlerThread, kotlin.g.a.a aVar, boolean z) {
            this.hvk = handlerThread;
            this.hvl = aVar;
            this.hvm = z;
        }

        public final void run() {
            AppMethodBeat.i(182801);
            this.hvl.invoke();
            if (this.hvm) {
                this.hvk.quitSafely();
            }
            AppMethodBeat.o(182801);
        }
    }

    public static final boolean cW(int i2, int i3) {
        return (i2 & i3) > 0;
    }

    public static final <T extends com.tencent.mm.bw.a> T a(T t, byte[] bArr, kotlin.g.a.b<? super Exception, x> bVar) {
        AppMethodBeat.i(153455);
        p.h(t, "$this$safeParser");
        p.h(bVar, "block");
        try {
            t.parseFrom(bArr);
            AppMethodBeat.o(153455);
            return t;
        } catch (Exception e2) {
            Log.printDebugStack("safeParser", "", e2);
            bVar.invoke(e2);
            AppMethodBeat.o(153455);
            return null;
        }
    }

    public static final String zs(long j2) {
        AppMethodBeat.i(168821);
        String binaryString = Long.toBinaryString(j2);
        p.g(binaryString, "java.lang.Long.toBinaryString(seq)");
        String bigInteger = new BigInteger(binaryString, 2).toString();
        p.g(bigInteger, "big.toString()");
        AppMethodBeat.o(168821);
        return bigInteger;
    }

    public static final long Ga(String str) {
        boolean z;
        long j2;
        AppMethodBeat.i(168822);
        if (str != null) {
            if (str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                try {
                    j2 = new BigInteger(str).longValue();
                } catch (Throwable th) {
                    Log.printErrStackTrace("Common.Kt", th, "", new Object[0]);
                    j2 = 0;
                }
                AppMethodBeat.o(168822);
                return j2;
            }
        }
        AppMethodBeat.o(168822);
        return 0;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, hxF = {"<no name provided>", "T", "invoke", "()Ljava/lang/Object;"})
    public static final class a extends q implements kotlin.g.a.a<T> {
        final /* synthetic */ z.d hvi;
        final /* synthetic */ List hvj;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(z.d dVar, List list) {
            super(0);
            this.hvi = dVar;
            this.hvj = list;
        }

        @Override // kotlin.g.a.a
        public final T invoke() {
            AppMethodBeat.i(153446);
            if (this.hvi.SYE < 0 || this.hvi.SYE >= this.hvj.size()) {
                AppMethodBeat.o(153446);
                return null;
            }
            List list = this.hvj;
            z.d dVar = this.hvi;
            int i2 = dVar.SYE;
            dVar.SYE = i2 + 1;
            T t = (T) list.get(i2);
            AppMethodBeat.o(153446);
            return t;
        }
    }

    public static final <T> boolean a(List<T> list, kotlin.g.a.b<? super T, Boolean> bVar) {
        boolean c2;
        AppMethodBeat.i(204386);
        p.h(list, "$this$synchronizedRemoveAll");
        p.h(bVar, "predicate");
        synchronized (list) {
            try {
                c2 = kotlin.a.j.c((List) list, (kotlin.g.a.b) bVar);
            } finally {
                AppMethodBeat.o(204386);
            }
        }
        return c2;
    }

    public static final void f(TextView textView) {
        AppMethodBeat.i(153457);
        p.h(textView, "textView");
        textView.setShadowLayer((float) com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 3), 0.0f, (float) com.tencent.mm.cb.a.fromDPToPix(textView.getContext(), 1), Integer.MIN_VALUE);
        AppMethodBeat.o(153457);
    }

    public static final com.tencent.mm.vending.g.c<Void> aBx() {
        AppMethodBeat.i(168823);
        com.tencent.mm.vending.g.c<Void> hdG = com.tencent.mm.vending.g.g.hdG();
        p.g(hdG, "QuickAccess.pipeline()");
        AppMethodBeat.o(168823);
        return hdG;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "R", "T", LocaleUtil.ITALIAN, "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class c<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b hvn;

        c(kotlin.g.a.b bVar) {
            this.hvn = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final R call(T t) {
            AppMethodBeat.i(168819);
            R r = (R) this.hvn.invoke(t);
            AppMethodBeat.o(168819);
            return r;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v6. Raw type applied. Possible types: com.tencent.mm.vending.g.c<_Ret>, java.lang.Object, com.tencent.mm.vending.g.c<R> */
    public static final <R, T> com.tencent.mm.vending.g.c<R> a(com.tencent.mm.vending.g.c<T> cVar, kotlin.g.a.b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(168824);
        p.h(cVar, "$this$thread");
        p.h(bVar, "func");
        com.tencent.mm.vending.g.c cVar2 = (com.tencent.mm.vending.g.c<_Ret>) cVar.b(h.hvt).c(new c(bVar));
        p.g(cVar2, "`$`(ThreadScheduler).next {\n        func(it)\n    }");
        AppMethodBeat.o(168824);
        return cVar2;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0004\n\u0002\b\u0007\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, hxF = {"<anonymous>", "R", "T", LocaleUtil.ITALIAN, "kotlin.jvm.PlatformType", "call", "(Ljava/lang/Object;)Ljava/lang/Object;"})
    static final class g<_Ret, _Var> implements com.tencent.mm.vending.c.a<_Ret, _Var> {
        final /* synthetic */ kotlin.g.a.b hvn;

        g(kotlin.g.a.b bVar) {
            this.hvn = bVar;
        }

        @Override // com.tencent.mm.vending.c.a
        public final R call(T t) {
            AppMethodBeat.i(168820);
            R r = (R) this.hvn.invoke(t);
            AppMethodBeat.o(168820);
            return r;
        }
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.tencent.mm.vending.g.c<_Ret>, java.lang.Object, com.tencent.mm.vending.g.c<R> */
    public static final <T, R> com.tencent.mm.vending.g.c<R> b(com.tencent.mm.vending.g.c<T> cVar, kotlin.g.a.b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(168825);
        p.h(cVar, "$this$ui");
        p.h(bVar, "func");
        com.tencent.mm.vending.g.c cVar2 = (com.tencent.mm.vending.g.c<_Ret>) cVar.f(new g(bVar));
        p.g(cVar2, "`$ui` {\n        func(it)\n    }");
        AppMethodBeat.o(168825);
        return cVar2;
    }

    public static final <T> boolean a(ArrayList<T> arrayList, kotlin.g.a.b<? super T, Boolean> bVar) {
        AppMethodBeat.i(204387);
        p.h(arrayList, "$this$wxRemoveIf");
        p.h(bVar, "func");
        ArrayList<T> arrayList2 = new ArrayList();
        for (T t : arrayList) {
            if (bVar.invoke(t).booleanValue()) {
                arrayList2.add(t);
            }
        }
        boolean z = !arrayList2.isEmpty();
        for (T t2 : arrayList2) {
            arrayList.remove(t2);
        }
        AppMethodBeat.o(204387);
        return z;
    }

    public static final <T> boolean a(LinkedList<T> linkedList, kotlin.g.a.b<? super T, Boolean> bVar) {
        AppMethodBeat.i(168826);
        p.h(linkedList, "$this$wxRemoveIf");
        p.h(bVar, "func");
        LinkedList<T> linkedList2 = new LinkedList();
        for (T t : linkedList) {
            if (bVar.invoke(t).booleanValue()) {
                linkedList2.add(t);
            }
        }
        boolean z = !linkedList2.isEmpty();
        for (T t2 : linkedList2) {
            linkedList.remove(t2);
        }
        AppMethodBeat.o(168826);
        return z;
    }

    public static final <T> T a(HashSet<T> hashSet, kotlin.g.a.b<? super T, Boolean> bVar) {
        AppMethodBeat.i(204388);
        p.h(hashSet, "$this$wxRemoveFirst");
        p.h(bVar, "func");
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (bVar.invoke(next).booleanValue()) {
                it.remove();
                AppMethodBeat.o(204388);
                return next;
            }
        }
        AppMethodBeat.o(204388);
        return null;
    }

    public static final <T> LongSparseArray<T> a(LongSparseArray<T> longSparseArray, m<? super Long, ? super T, Boolean> mVar) {
        AppMethodBeat.i(204389);
        p.h(longSparseArray, "$this$filter");
        p.h(mVar, "func");
        LongSparseArray<T> longSparseArray2 = new LongSparseArray<>();
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            long keyAt = longSparseArray.keyAt(i2);
            T valueAt = longSparseArray.valueAt(i2);
            if (mVar.invoke(Long.valueOf(keyAt), valueAt).booleanValue()) {
                longSparseArray2.put(keyAt, valueAt);
            }
        }
        AppMethodBeat.o(204389);
        return longSparseArray2;
    }

    public static final <T> LongSparseArray<T> b(LongSparseArray<T> longSparseArray, m<? super Long, ? super T, x> mVar) {
        AppMethodBeat.i(204390);
        p.h(longSparseArray, "$this$forEach");
        p.h(mVar, "func");
        int size = longSparseArray.size();
        for (int i2 = 0; i2 < size; i2++) {
            long keyAt = longSparseArray.keyAt(i2);
            mVar.invoke(Long.valueOf(keyAt), longSparseArray.valueAt(i2));
        }
        AppMethodBeat.o(204390);
        return longSparseArray;
    }

    public static final void a(Intent intent, Bundle bundle, String str) {
        AppMethodBeat.i(204391);
        p.h(intent, "$this$copyStringExtra");
        p.h(str, "key");
        intent.putExtra(str, bundle != null ? bundle.getString(str) : null);
        AppMethodBeat.o(204391);
    }

    public static /* synthetic */ void b(Intent intent, Bundle bundle, String str) {
        Boolean bool;
        AppMethodBeat.i(204392);
        p.h(intent, "$this$copyBooleanExtra");
        p.h(str, "key");
        if (bundle != null) {
            bool = Boolean.valueOf(bundle.getBoolean(str, false));
        } else {
            bool = null;
        }
        intent.putExtra(str, bool);
        AppMethodBeat.o(204392);
    }

    public static /* synthetic */ void c(Intent intent, Bundle bundle, String str) {
        Integer num;
        AppMethodBeat.i(204393);
        p.h(intent, "$this$copyIntExtra");
        p.h(str, "key");
        if (bundle != null) {
            num = Integer.valueOf(bundle.getInt(str, 0));
        } else {
            num = null;
        }
        intent.putExtra(str, num);
        AppMethodBeat.o(204393);
    }

    public static /* synthetic */ void a(Intent intent, Intent intent2, String str) {
        Integer num;
        AppMethodBeat.i(259832);
        p.h(intent, "$this$copyIntExtra");
        p.h(str, "key");
        if (intent2 != null) {
            num = Integer.valueOf(intent2.getIntExtra(str, 0));
        } else {
            num = null;
        }
        intent.putExtra(str, num);
        AppMethodBeat.o(259832);
    }

    public static final void d(Intent intent, Bundle bundle, String str) {
        AppMethodBeat.i(204394);
        p.h(intent, "$this$copyStringArrayListExtra");
        p.h(str, "key");
        intent.putExtra(str, bundle != null ? bundle.getStringArrayList(str) : null);
        AppMethodBeat.o(204394);
    }

    public static final int[] cm(View view) {
        AppMethodBeat.i(204395);
        p.h(view, "$this$getLocationOnScreen");
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        AppMethodBeat.o(204395);
        return iArr;
    }

    public static final int[] cn(View view) {
        AppMethodBeat.i(204396);
        p.h(view, "$this$getLocationInWindow");
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        AppMethodBeat.o(204396);
        return iArr;
    }

    public static final String Gb(String str) {
        AppMethodBeat.i(204397);
        p.h(str, "$this$wxSubString");
        if (1 > str.length()) {
            String str2 = str.toString();
            AppMethodBeat.o(204397);
            return str2;
        }
        String substring = str.substring(0, 1);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(204397);
        return substring;
    }
}
