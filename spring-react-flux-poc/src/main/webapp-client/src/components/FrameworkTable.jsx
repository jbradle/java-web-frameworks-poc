import React from "react";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";
import FrameworkDetail from "./FrameworkDetail.jsx"
import FrameworkEdit from "./FrameworkEdit.jsx"
import FrameworkRow from './FrameworkRow.jsx'
import FrameworkAction from "../flux/actions/frameworkAction.jsx";

class FrameworkTable extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            frameworks: props.frameworks,
            showDetail: false,
            showEdit: false
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

    reloadTable() {
        FrameworkAction.getFrameworks();
    }

    saveFramework(framework) {

    }

    render() {
        let framework = this.state.framework;
        let categories = this.state.categories;

        if (this.state.showDetail) {
            return <FrameworkDetail {...{framework: framework, backFce: this.reloadTable}}/>
        }

        if (this.state.showEdit) {
            return <FrameworkEdit {...{framework: framework, categories: categories, saveFce: this.saveFramework}}/>
        }

        let frameworks = this.state.frameworks.map(framework =>
            <FrameworkRow key={framework.id}  {...{framework: framework}}/>
        );

        return (
            <table className="table table-hover">
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Category</th>
                    <th>Docs</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {frameworks}
                </tbody>
            </table>
        );
    }
}

FrameworkTable.propTypes = {
    frameworks: React.PropTypes.array
};

export default FrameworkTable;