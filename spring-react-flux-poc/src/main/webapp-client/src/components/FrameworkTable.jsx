import React from "react";
import FrameworkStore from "../flux/stores/frameworkStore.jsx";
import FrameworkDetail from "./FrameworkDetail.jsx"
import FrameworkRow from './FrameworkRow.jsx'
import FrameworkAction from "../flux/actions/frameworkAction.jsx";

class FrameworkTable extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            frameworks: props.frameworks,
            showDetail: false,
            frameworkDetail: {}
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

    reloadTable(){
        FrameworkAction.getFrameworks();
    }

    render() {

        if (this.state.showDetail) {
            return <FrameworkDetail {...{framework:this.state.framework, backFce : this.reloadTable}}/>
        }

        let frameworks = this.state.frameworks.map(framework =>
            <FrameworkRow key={framework.id}  {...{framework : framework}}/>
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
    frameworks: React.PropTypes.array,
    handleDetail: React.PropTypes.func
};

export default FrameworkTable;