# TIN175 Face Detection Using Viola-Jones Algorithm

The [ATT Database of Faces](https://www.cl.cam.ac.uk/research/dtg/attarchive/facedatabase.html).

The [Catalano Framework](https://github.com/DiegoCatalano/Catalano-Framework) used for image processing.

## Setup
One way to setup your local development environment for this project is the following.

1. Create an IDE project (Intellij IDEA, Eclipse, etc.) in the __parent__ folder of project root, that is, outside of source control (git).
2. Add the repository folder (by default called `code`) to your project if it was not visible automatically.
3. Add libraries in `code/libs` to your project libraries. (In Intellij File -> Project structure -> libraries -> plus symbol -> select all jars and the zip file containing javadoc)
4. Mark `code/src` as the code source folder. (In Intellij, right click -> mark as.. -> source folder)
5. Mark `code/res` as resources folder, `code/test` as test source, `code/test-res` as test resources.
6. Try running a main file to create a run configuration. It will fail to find any files to run on. Now edit your run configuration and set the __working directory__ to point to the project root directory (`code`).


## Current Usage
When running files, make sure that your current working directory is the project root. If you are running from the terminal this means you should be at `[placeInYourFileSystem]/code`, not in any subfolder. If you are running from an IDE such as Eclipse or Intellij IDEA you need to make sure the current working directory is correctly set in your current run configuration. If you have not done this, any hardcoded paths will fail to find the right images etc.

1. Run java file in project root to copy and rename images from att folder structure to `att-faces-java`.
2. Run `prepareImages.sh` (bash script) to crop and rescale all images into `att-faces-scaled`.
3. Use cropped and rescaled images somehow.

### Catalano IntegralImage
Catalano has limited documentation, so it can help to look at the source code, here is For reference, here is the [Catalano IntegralImage](https://github.com/DiegoCatalano/Catalano-Framework/blob/master/Catalano.Image/src/Catalano/Imaging/Tools/IntegralImage.java) on GitHub.

In particular, when using `IntegralImage.getRectangularSum(x1, y1, x2, y2)` where `(x1, y1)` is the top left and `(x2, y2)` is the bottom right of the selection, note that `(0, 0)` is the bottom right of the image and `(24, 24)` is the top left, if the image is 25x25.

## TODO

* Get and add to the dataset images that are not faces.
