package com.jackhou.utilslibrary.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import com.jackhou.utilslibrary.app.JackApplication;

/**
 * author: liutao
 * date: 2016/6/22.
 */
public class ToastUtil {

    private static ProgressDialog progressDialog;
    private static Toast mToast;

    public static void tip(Context context, String s) {
        showToast(context, s);
    }

    public static void tip(Context context, int resId) {
        showToast(context, resId, Toast.LENGTH_SHORT);
    }

    public static void tip(Context context, String s, int duration){
        showToast(context, s, duration);
    }

    /**
     * 弹出一个progressDialog
     *
     * @param context    context
     * @param message    提示信息
     * @param cancelable 能否返回取消
     */
    public synchronized static void showProgressDialog(Context context, String message, boolean cancelable) {
        if (progressDialog == null || progressDialog.getContext() != context) {
            progressDialog = null;
            progressDialog = new ProgressDialog(context);
            progressDialog.setCancelable(cancelable);// 设置是否可以通过点击Back键取消
            progressDialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        }
        progressDialog.setMessage(message);
        progressDialog.show();
    }


    public static void dismiss() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }

    }

    public static boolean isDismiss() {
        return progressDialog == null || !progressDialog.isShowing();
    }

    public static void dismissProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public static void destory() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
        closeToast();
    }

    public static Toast toast = null;
    public static Toast toastBack = null;
    public static Toast longToast = null;

    public static void showToast(Context context, String text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JackApplication.getInstance(), text, duration);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    public static void showToast(String text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JackApplication.getInstance(), text, duration);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    public static void showToast(Context context, int resId, int duration) {
        if (toast == null) {
            toast = Toast.makeText(JackApplication.getInstance(), resId, duration);
        } else {
            toast.setText(JackApplication.getInstance().getString(resId));
        }
        toast.show();
    }

    public static void showToast(Context context, String text) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(JackApplication.getInstance(), text, Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showToast(String text) {
        if (TextUtils.isEmpty(text)) {
            return;
        }
        if (toast == null) {
            toast = Toast.makeText(JackApplication.getInstance(), text, Toast.LENGTH_SHORT);
        } else {
            toast.setText(text);
        }
        toast.show();
    }

    public static void showToast(int resId) {
        if (toast == null) {
            toast = Toast.makeText(JackApplication.getInstance(), JackApplication.getInstance().getResources().getString(resId), Toast.LENGTH_SHORT);
        } else {
            toast.setText(JackApplication.getInstance().getResources().getString(resId));
        }
        toast.show();
    }

    public static void closeToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

}

