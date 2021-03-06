var gulp = require('gulp');
var browserSync = require('browser-sync');

gulp.task('browser-sync', function () {
    var files = [
        '*.html'
    ];

    browserSync.init(files, {
        server: {
            baseDir: '.'
        }
    });
});

gulp.task('default', ['browser-sync']);