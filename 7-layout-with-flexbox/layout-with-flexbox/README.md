layout-with-flexbox
===================

Equivalent example of [Layout with Flexbox]

-------------------------------------------------------------------------------

Usage
-----

1. Run `Genymotion` and start virtual device

    _e.g. `Custom Phone - 6.0.0 - API 23 - 768x1280`._

2. Open a terminal then paste the following:

    ``` bash
    $ \
    cd rena/7-layout-with-flexbox/layout-with-flexbox/  # move to project directory
    re-natal deps                                       # download project dependencies
    re-natal use-android-device genymotion              # set the host for device type
    re-natal use-figwheel                               # generate *.js files for figwheel
    lein figwheel android                               # run figwheel on Android device (e.g. Genymotion)
    ```

3. Open a new terminal tab then paste the following:

    ``` bash
    # Deploy the project on Android (e.g. Genymotion):
    $ react-native run-android
    ```

[Layout with Flexbox]: https://facebook.github.io/react-native/docs/flexbox.html
