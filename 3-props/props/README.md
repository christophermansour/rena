props
=====

Equivalent example of [Props]

-------------------------------------------------------------------------------

Usage
-----

1. Run `Genymotion` and start virtual device

  _e.g. `Custom Phone - 6.0.0 - API 23 - 768x1280`._

2. Open a terminal then do the following:

  ``` bash
  # Go to android directory:
  $ cd rn-rn/2-props/props

  # Download dependencies:
  $ re-natal deps

  # Open a terminal then paste the following:
  $ \
  re-natal use-android-device genymotion
  re-natal use-figwheel
  lein figwheel android
  ```

3. Open a new terminal tab then paste the following:

  ``` bash
  $ react-native run-android
  ```

[Props]: https://facebook.github.io/react-native/docs/props.html
