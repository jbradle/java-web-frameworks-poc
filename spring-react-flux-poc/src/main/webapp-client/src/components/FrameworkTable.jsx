import React from "react";
import FrameworkDetail from "./FrameworkDetail.jsx";
import FrameworkEdit from "./FrameworkEdit.jsx";
import FrameworkRow from "./FrameworkRow.jsx";
import FrameworkAction from "../flux/actions/frameworkAction.jsx";

class FrameworkTable extends React.Component {

    reloadTable() {
        FrameworkAction.getFrameworks();
    }

    render() {

        if (this.props.showDetail) {
            return <FrameworkDetail {...{
                framework: this.props.framework,
                backFce: this.reloadTable
            }}/>
        }

        if (this.props.showEdit) {
            return <FrameworkEdit {...{
                framework: this.props.framework, 
                categories: this.props.categories
            }}/>
        }

        let frameworkRows = this.props.frameworks.map(framework =>
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
                {frameworkRows}
                </tbody>
            </table>
        );
    }
}

FrameworkTable.propTypes = {
    frameworks: React.PropTypes.array
};

export default FrameworkTable;