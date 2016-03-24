import React from "react";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";

class FrameworkEdit extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            categories: props.categories,
            framework: props.framework
        };
    }

    componentDidMount() {
        this.unsubscribe = FrameworkStore.listen(this.onStatusChange.bind(this));
    }

    componentWillUnmount() {
        this.unsubscribe();
    }

    onStatusChange(state) {
        this.setState(state);
    }

    onChange(event) {
        this.state.framework[event.target.id] = event.target.value;
    }

    saveFramework() {
        if (!this.state.framework.categoryId) {
            this.state.framework.categoryId = 1;
        }
        FrameworkAction.saveFramework(this.state.framework);
    }

    render() {
        let framework = this.state.framework;

        let categories = this.state.categories.map(category =>
            <option key={category.id} value={category.id}>{category.name}</option>
        );

        return (
            <div className="well">
                <h4>Edit Framework</h4>
                <form onChange={this.onChange.bind(this)}>
                    <input type="hidden" value={framework.id}/>

                    <div className="control-group form-group">
                        <div className="controls">
                            <label htmlFor="name">Name:</label>
                            <input type="text" className="form-control" id="name"
                                   defaultValue={framework.name}/>
                            <p className="help-block"/>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <div className="controls">
                            <label htmlFor="description">Description:</label>
                                <textarea className="form-control" rows="3" id="description"
                                          defaultValue={framework.description}/>

                            <div className="help-block"></div>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <div className="controls">
                            <label htmlFor="documentationLink">Documentation Link:</label>
                            <input type="text" className="form-control" id="documentationLink"
                                   defaultValue={framework.documentationLink}/>

                            <div className="help-block"></div>
                        </div>
                    </div>
                    <div className="control-group form-group">
                        <label htmlFor="categoryId">Category:</label>
                        <select className="form-control" id="categoryId" defaultValue={framework.category.id}>
                            {categories}
                        </select>
                    </div>
                </form>
                <button className="btn btn-primary" onClick={this.saveFramework.bind(this)}>Save</button>
            </div>
        );
    }
}

FrameworkEdit.propTypes = {
    framework: React.PropTypes.object,
    categories: React.PropTypes.array
};

export default FrameworkEdit;