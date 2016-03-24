import Reflux from "reflux";
import {get, post, del} from "../rest/api.jsx";

const FrameworkActions = Reflux.createActions({
    'getFrameworks': {children: ['completed', 'failed']},
    'searchFrameworks': {children: ['completed', 'failed']},
    'showEdit': {children: ['completed', 'failed']},
    'showDetail': {},
    'deleteFramework': {children: ['completed', 'failed']},
    'saveFramework': {children: ['completed', 'failed']}
});

const REST_URI = 'http://localhost:8080/rest/';

FrameworkActions.getFrameworks.listen(function () {

    get(REST_URI + 'getAllFrameworks')
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});

FrameworkActions.searchFrameworks.listen(function (searchParam) {

    get(REST_URI + 'searchFrameworks?searchParam=' + searchParam)
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});

FrameworkActions.showEdit.listen(function (framework) {

    get(REST_URI + 'getAllCategories')
        .then((categories) => {
            this.completed(framework, categories);
        }).catch((err) => {
        this.failed(err);
    });

});

FrameworkActions.saveFramework.listen(function (framework) {

    post(REST_URI + 'saveFramework', framework)
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});

FrameworkActions.deleteFramework.listen(function (framework) {

    del(REST_URI + 'deleteFramework', framework)
        .then((frameworks) => {
            this.completed(frameworks);
        }).catch((err) => {
        this.failed(err);
    });

});


export default FrameworkActions;