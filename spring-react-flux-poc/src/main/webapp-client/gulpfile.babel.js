import gulp from "gulp";
import del from "del";
import yargs from "yargs";
import gulpif from "gulp-if";
import uglify from "gulp-uglify";
import size from "gulp-size";
import browserSync from "browser-sync";
import webpackConfig from "./webpack.config";

var $ = require('gulp-load-plugins')();

var production = yargs.argv.production;
var config = webpackConfig(production);

var dist = '../webapp/';
var src = 'src/';

gulp.task('html', () => {
    return gulp.src('src/index.html')
        .pipe(gulp.dest(dist))
        .pipe(size({title: 'html'}));
});

gulp.task('app', () => {
    return gulp.src(config.entry)
        .pipe($.webpack(config))
        .pipe(gulpif(production, uglify()))
        .pipe(gulp.dest(dist + '/js'))
        .pipe(size({title: 'app'}));
});

gulp.task('clean', (callBack) => {
    return del([dist + 'js/**/*.*', dist + '*.html'], {force: true}, callBack);
});

gulp.task('browser-sync', () => {
    browserSync({
        files: dist + 'js/app.js',
        server: {
            baseDir: '../webapp/'
        }
    });
});

gulp.task('watch', () => {
    gulp.watch(src + 'index.html', ['html']);
    gulp.watch(src + '**/*.jsx', ['app']);
});


gulp.task('default', ['html', 'app'], () => {
    gulp.start(['browser-sync', 'watch']);
});

gulp.task('build', ['clean'], () => {
    gulp.start(['html', 'app']);
});