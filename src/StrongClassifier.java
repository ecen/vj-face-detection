import java.io.Serializable;
import java.util.ArrayList;

public class StrongClassifier implements Serializable{
    ArrayList<Classifier> weakClassifiers;
    private double threshold;
    private double thresholdMultiplier = 1;

    public StrongClassifier(ArrayList<Classifier> weakClassifiers) throws Exception {
        this.weakClassifiers = weakClassifiers;

        threshold = 0;
        for(Classifier c:weakClassifiers){
            threshold+=c.getAlpha();
        }

    }

    public void setThresholdMultiplier(double thresholdMultiplier) throws Exception {
        if (thresholdMultiplier < 0 || thresholdMultiplier > 1) throw new Exception("Threshold multiplier has to be in [0,1]. Was: " + thresholdMultiplier);
        this.thresholdMultiplier = thresholdMultiplier;
    }

    public double getThresholdMultiplier() {
        return thresholdMultiplier;
    }

    public boolean canBeFace(HalIntegralImage img) throws Exception {
        //How it looks like you should do according to the paper:

        double value = 0;
        for(Classifier c:weakClassifiers){
            value+=c.getAlpha()*c.canBeFace(img);
        }

        return value>=threshold*thresholdMultiplier;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StrongClassifier)) return false;
        StrongClassifier c = (StrongClassifier) o;

        if(weakClassifiers.size() != c.weakClassifiers.size()) return false;

        for (int i = 0; i < weakClassifiers.size(); i++) {
            Classifier weakClassifier = weakClassifiers.get(i);

            if(!weakClassifier.equals(c.weakClassifiers.get(i))){
                return false;
            }
        }
        return true;
    }
}
