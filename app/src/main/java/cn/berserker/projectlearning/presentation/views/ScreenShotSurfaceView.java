package cn.berserker.projectlearning.presentation.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 *  capture surface screen.
 */
public class ScreenShotSurfaceView extends SurfaceView {

    public ScreenShotSurfaceView(Context context) {
        super(context);
    }

    public ScreenShotSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScreenShotSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public SurfaceHolder getHolder() {
        return new ProxyHolder(super.getHolder());
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mOnScreenRecordListener = null;
    }


    private class ProxyHolder implements SurfaceHolder {

        SurfaceHolder mHolder;

        ProxyHolder(SurfaceHolder holder) {
            mHolder = holder;
        }

        @Override
        public void addCallback(Callback callback) {
            mHolder.addCallback(callback);
        }

        @Override
        public void removeCallback(Callback callback) {
            mHolder.removeCallback(callback);
        }

        @Override
        public boolean isCreating() {
            return mHolder.isCreating();
        }

        @Override
        public void setType(int type) {
            mHolder.setType(type);
        }

        @Override
        public void setFixedSize(int width, int height) {
            mHolder.setFixedSize(width, height);
        }

        @Override
        public void setSizeFromLayout() {
            mHolder.setSizeFromLayout();
        }

        @Override
        public void setFormat(int format) {
            mHolder.setFormat(format);
        }

        @Override
        public void setKeepScreenOn(boolean screenOn) {
            mHolder.setKeepScreenOn(screenOn);
        }

        @Override
        public Canvas lockCanvas() {
            Canvas canvas = mHolder.lockCanvas();
            if(null != canvas && null != mOnScreenRecordListener) {
                Bitmap bitmap = mOnScreenRecordListener.getScreenshotHolder();
                canvas.setBitmap(bitmap);
            }
            return canvas;
        }


        @Override
        public Canvas lockCanvas(Rect dirty) {
            return mHolder.lockCanvas(dirty);
        }

        @Override
        public void unlockCanvasAndPost(Canvas canvas) {
            mHolder.unlockCanvasAndPost(canvas);
        }

        @Override
        public Rect getSurfaceFrame() {
            return mHolder.getSurfaceFrame();
        }

        @Override
        public Surface getSurface() {
            return mHolder.getSurface();
        }
    }


    private OnScreenRecordListener mOnScreenRecordListener;

    public void addScreenRecordListener(OnScreenRecordListener listener) {
        mOnScreenRecordListener = listener;
    }

    public interface OnScreenRecordListener {
        Bitmap getScreenshotHolder();
    }



}
