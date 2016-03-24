import Reflux from 'reflux';
import FrameworkAction from '../actions/frameworkAction.jsx';

let FrameworkStore = Reflux.createStore({
    listenables: FrameworkAction,

    init() {
        this.frameworks = [];
        this.categories = []
    },

    getFrameworksCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: this.frameworks,
            showDetail: false
        });
    },

    getFrameworksFailed(error) {
        this.trigger({
            error: error
        });
    },

    searchFrameworksCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: this.frameworks
        });
    },

    searchFrameworksFailed(error) {
        this.trigger({
            error: error
        });
    },

    onShowDetail(framework){
        this.trigger({
            showDetail: true,
            framework: framework
        });
    },

    showEditCompleted(framework, categories){
        this.categories = categories;
        
        this.trigger({
            showEdit: true,
            framework: framework,
            categories: categories
        });
    },

    showEditFailed(error) {
        this.trigger({
            error: error
        });
    },

    saveFrameworkCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: frameworks,
            showDetail: false,
            showEdit: false
        });
    },

    saveFrameworkFailed(error) {
        this.trigger({
            error: error
        });
    },

    deleteFrameworkCompleted(frameworks) {
        this.frameworks = frameworks;

        this.trigger({
            frameworks: frameworks,
            showDetail: false,
            showEdit: false
        });
    },

    deleteFrameworkFailed(error) {
        this.trigger({
            error: error
        });
    }

});

export default FrameworkStore;