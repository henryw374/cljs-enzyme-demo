# cljs enzyme demo

start cljs repl and connect with `phantom dev-resources/phantom-test.js`

see enzyme.cljs for commands to run

The rest of the project and below docs come from the lein re-frame template


A [re-frame](https://github.com/Day8/re-frame) application designed to ... well, that part is up to you.

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```
